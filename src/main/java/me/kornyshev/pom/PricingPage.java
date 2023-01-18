package me.kornyshev.pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class PricingPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'ui-section__container')]//div[contains(@class, 'UiPricingGridstyles')]//h2")
    private List<WebElement> plansHeaders;

    public PricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
