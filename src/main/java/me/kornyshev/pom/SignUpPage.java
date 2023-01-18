package me.kornyshev.pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class SignUpPage {

    private final WebDriver driver;

    @FindBy(css = "div#signup-form div#login-prompt + h1")
    private WebElement title;

    @FindBy(css = "form.sign-up-container input#email")
    private WebElement emailField;
    @FindBy(css = "form.sign-up-container input[value='Continue']")
    private WebElement continueButton;
    @FindBy(css = "form#form-sign-up button#signup-submit")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
