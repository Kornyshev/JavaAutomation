package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import me.kornyshev.flow.SignUpPageFlow;
import me.kornyshev.utils.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SignUpPageTests extends BaseTests {

    SignUpPageFlow signUpPageFlow;

    @BeforeEach
    void setupTest() {
        new MainNotLoggedInPageFlow(driver).clickSignUpButton();
        signUpPageFlow = new SignUpPageFlow(driver);
    }

    @Test
    void verifyTitleOnSignUpPage() {
        log.info("Test: Verify Title on Sign Up Page");
        assertThat(signUpPageFlow.getPageTitle()).isEqualTo("Sign up for your account");
        signUpPageFlow.setEmailValue("text" + DataUtils.timestamp() + "@email.com");
        signUpPageFlow.clickContinueButton();
        assertThat(signUpPageFlow.getPageTitle()).isEqualTo("Sign up for your account");
    }

}
