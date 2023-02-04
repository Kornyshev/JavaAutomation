package me.kornyshev.flow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import me.kornyshev.pom.PricingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class PricingPageFlow extends SeleniumActions {

    PricingPage pricingPage;

    public PricingPageFlow(WebDriver driver) {
        this.driver = driver;
        this.pricingPage = new PricingPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Get displayed Plans headers on Pricing Page")
    public List<String> getDisplayedPlansHeaders() {
        log.info("Getting displayed plans headers");
        wait.until(visibilityOf(pricingPage.getPlansHeaders().get(0)));
        return pricingPage.getPlansHeaders().stream().map(WebElement::getText).toList();
    }

}
