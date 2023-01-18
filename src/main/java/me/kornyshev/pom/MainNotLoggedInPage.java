package me.kornyshev.pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MainNotLoggedInPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'NavBar')]//a[@href='/login']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class, 'NavBar')]//a[@href='/signup']")
    private WebElement signupButton;
    @FindBy(xpath = "//div[contains(@class, 'NavBar')]//a[@href='/pricing']")
    private WebElement pricingLink;

    public MainNotLoggedInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
