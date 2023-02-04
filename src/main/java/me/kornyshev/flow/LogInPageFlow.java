package me.kornyshev.flow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import me.kornyshev.models.User;
import me.kornyshev.pom.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class LogInPageFlow extends SeleniumActions {

    LogInPage logInPage;

    public LogInPageFlow(WebDriver driver) {
        this.driver = driver;
        this.logInPage = new LogInPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Step("Set Email to Log In field on Log In form")
    public void setEmailToLogInField(String email) {
        setValue(logInPage.getLoginField(), email);
    }

    @Step("Set Password to Password field on Log In form")
    public void setPassToPasswordField(String pass) {
        setValue(logInPage.getPasswordField(), pass);
    }

    @Step("Click Continue button on Log In form")
    public void clickContinueButton() {
        click(logInPage.getContinueButton());
    }

    @Step("Click Log In button on Log In form")
    public void clickLogInButton() {
        click(logInPage.getLogInButton());
    }

    @Step("Perform Log In")
    public void performLogInAsUser(User user) {
        setEmailToLogInField(user.getEmail());
        clickContinueButton();
        wait.until(visibilityOf(new LogInPage(driver).getPasswordField()));
        setPassToPasswordField(user.getPassword());
        clickLogInButton();
    }

}
