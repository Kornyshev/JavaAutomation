package me.kornyshev.flow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class SeleniumActions {

    Wait<WebDriver> wait;
    WebDriver driver;

    public void click(WebElement element) {
        log.info("Wait and click element: {}", element.toString());
        wait.until(visibilityOf(element));
        element.click();
    }

    public void setValue(WebElement element, String value) {
        log.info("Wait and set value to element: {}", element.toString());
        wait.until(visibilityOf(element));
        element.sendKeys(value);
    }

    @Step("Navigate back")
    public void navigateBack() {
        driver.navigate().back();
    }

}
