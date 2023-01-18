package utils;

import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Slf4j
public class ScreenshotOnFailureExtension implements AfterTestExecutionCallback {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        ScreenshotOnFailureExtension.driver = driver;
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws FileNotFoundException {
        log.info("After method '{}' extension", extensionContext.getRequiredTestMethod().getName());
        if (extensionContext.getExecutionException().isPresent()) {
            log.info("Let's take a screenshot");
            final File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", new FileInputStream(screenshot));
        }
    }
}
