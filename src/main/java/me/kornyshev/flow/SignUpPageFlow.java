package me.kornyshev.flow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import me.kornyshev.pom.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class SignUpPageFlow extends SeleniumActions {

    SignUpPage signUpPage;
    WebDriver driver;

    public SignUpPageFlow(WebDriver driver) {
        this.driver = driver;
        this.signUpPage = new SignUpPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Set Email value to the field")
    public void setEmailValue(String email) {
        setValue(signUpPage.getEmailField(), email);
    }

    @Step("Click Continue button")
    public void clickContinueButton() {
        click(signUpPage.getContinueButton());
    }

    @Step("Click Sign Up button")
    public void clickSignUpButton() {
        click(signUpPage.getSignUpButton());
    }

    @Step("Wait for Sign Up button")
    public void waitForSignUpButton() {
        log.info("Waiting for Sign Up button");
        wait.until(visibilityOf(signUpPage.getSignUpButton()));
    }

    @Step("Get initial title on the page")
    public String getPageTitle() {
        log.info("Getting initial title on the page");
        return wait.until(visibilityOf(signUpPage.getTitle())).getText();
    }

}
