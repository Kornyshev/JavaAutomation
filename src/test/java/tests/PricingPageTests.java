package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import me.kornyshev.flow.PricingPageFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenshotOnFailureExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(ScreenshotOnFailureExtension.class)
public class PricingPageTests extends BaseTests {

    MainNotLoggedInPageFlow mainNotLoggedInPageFlow;
    PricingPageFlow pricingPageFlow;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        ScreenshotOnFailureExtension.setDriver(driver);
        mainNotLoggedInPageFlow = new MainNotLoggedInPageFlow(driver);
        mainNotLoggedInPageFlow.clickPricingLink();
        pricingPageFlow = new PricingPageFlow(driver);
    }

    @Test
    void verifyDisplayedPlans() {
        log.info("Test: Verify displayed plans on Pricing Page");
        List<String> expectedHeaders = List.of("FREE", "STANDARD", "PREMIUM", "ENTERPRISE");
        assertThat(pricingPageFlow.getDisplayedPlansHeaders()).isEqualTo(expectedHeaders);
    }

}
