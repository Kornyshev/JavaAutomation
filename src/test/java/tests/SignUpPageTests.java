package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import me.kornyshev.flow.SignUpPageFlow;
import me.kornyshev.utils.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenshotOnFailureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(ScreenshotOnFailureExtension.class)
public class SignUpPageTests extends BaseTests {

    MainNotLoggedInPageFlow mainNotLoggedInPageFlow;
    SignUpPageFlow signUpPageFlow;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        ScreenshotOnFailureExtension.setDriver(driver);
        mainNotLoggedInPageFlow = new MainNotLoggedInPageFlow(driver);
        mainNotLoggedInPageFlow.clickSignUpButton();
        signUpPageFlow = new SignUpPageFlow(driver);
    }

    @Test
    void verifyTitleOnSignUpPage() {
        // Failed tests. I will keep it as screenshot example.
        log.info("Test: Verify Title on Sign Up Page");
        assertThat(signUpPageFlow.getPageTitle()).isEqualTo("Sign up for your account");
        signUpPageFlow.setEmailValue("text" + DataUtils.timestamp() + "@email.com");
        signUpPageFlow.clickContinueButton();
        signUpPageFlow.waitForSignUpButton();
        assertThat(signUpPageFlow.getPageTitle()).isEqualTo("Sign up for your account");
    }

}
