package me.kornyshev.flow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import me.kornyshev.pom.MainNotLoggedInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class MainNotLoggedInPageFlow extends SeleniumActions {

    MainNotLoggedInPage mainNotLoggedInPage;

    public MainNotLoggedInPageFlow(WebDriver driver) {
        this.driver = driver;
        this.mainNotLoggedInPage = new MainNotLoggedInPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Click Log In button")
    public void clickLogInButton() {
        click(mainNotLoggedInPage.getLoginButton());
    }

    @Step("Click Pricing link")
    public void clickPricingLink() {
        wait.until(visibilityOf(mainNotLoggedInPage.getPricingLink())).click();
    }

    @Step("Click Sign Up button")
    public void clickSignUpButton() {
        click(mainNotLoggedInPage.getSignupButton());
    }

    @Step("Get Log In button text")
    public String getLoginButtonText() {
        log.info("Getting Log In button text");
        return wait.until(visibilityOf(mainNotLoggedInPage.getLoginButton())).getText();
    }

    @Step("Get Sign Up button text")
    public String getSignUpButtonText() {
        log.info("Getting Sign Up button text");
        return wait.until(visibilityOf(mainNotLoggedInPage.getSignupButton())).getText();
    }

}
