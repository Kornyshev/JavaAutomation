package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MainNotLoggedInPageTests extends BaseTests {

    MainNotLoggedInPageFlow mainNotLoggedInPageFlow;

    @BeforeEach
    void setupTest() {
        mainNotLoggedInPageFlow = new MainNotLoggedInPageFlow(driver);
    }

    @Test
    void verifyLoginAndSignUpButtonTexts() {
        log.info("Test: Verify text of Log In and Sign Up button");
        assertThat(mainNotLoggedInPageFlow.getLoginButtonText()).isEqualTo("Log in");
        assertThat(mainNotLoggedInPageFlow.getSignUpButtonText()).isEqualTo("Get Trello for free");
    }

}
