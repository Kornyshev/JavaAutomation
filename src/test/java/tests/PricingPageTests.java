package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import me.kornyshev.flow.PricingPageFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class PricingPageTests extends BaseTests {

    PricingPageFlow pricingPageFlow;

    @BeforeEach
    void setupTest() {
        new MainNotLoggedInPageFlow(driver).clickPricingLink();
        pricingPageFlow = new PricingPageFlow(driver);
    }

    @Test
    void verifyDisplayedPlans() {
        log.info("Test: Verify displayed plans on Pricing Page");
        List<String> expectedHeaders = List.of("FREE", "STANDARD", "PREMIUM", "ENTERPRISE");
        assertThat(pricingPageFlow.getDisplayedPlansHeaders()).isEqualTo(expectedHeaders);
    }

}
