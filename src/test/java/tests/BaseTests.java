package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenshotOnFailureExtension;

@Slf4j
@ExtendWith(ScreenshotOnFailureExtension.class)
public abstract class BaseTests {

    public WebDriver driver;

    @BeforeAll
    static void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void openBrowser() {
        log.info("Creating Driver object...");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        ScreenshotOnFailureExtension.setDriver(driver);
    }

    @AfterEach
    void teardown() {
        driver.close();
    }

}
