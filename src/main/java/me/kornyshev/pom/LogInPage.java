package me.kornyshev.pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LogInPage {

    private final WebDriver driver;

    @FindBy(css = "form#login-form input[placeholder='Enter email']")
    private WebElement loginField;
    @FindBy(css = "form#login-form input[value='Continue']")
    private WebElement continueButton;
    @FindBy(css = "form input[placeholder='Enter password']")
    private WebElement passwordField;
    @FindBy(css = "form button#login-submit")
    private WebElement logInButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
