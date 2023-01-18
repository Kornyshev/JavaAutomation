package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ScreenshotOnFailureExtension;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(ScreenshotOnFailureExtension.class)
public class MainNotLoggedInPageTests extends BaseTests {

    MainNotLoggedInPageFlow mainNotLoggedInPageFlow;

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        ScreenshotOnFailureExtension.setDriver(driver);
        mainNotLoggedInPageFlow = new MainNotLoggedInPageFlow(driver);
    }

    @Test
    void verifyLoginAndSignUpButtonTexts() {
        log.info("Test: Verify text of Log In and Sign Up button");
        assertThat(mainNotLoggedInPageFlow.getLoginButtonText()).isEqualTo("Log in");
        assertThat(mainNotLoggedInPageFlow.getSignUpButtonText()).isEqualTo("Get Trello for free");
    }

}
