package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.LogInPageFlow;
import me.kornyshev.flow.MainLoggedInPageFlow;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import me.kornyshev.models.User;
import me.kornyshev.properties.PropertyLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LogInTests extends BaseTests {

    LogInPageFlow logInPageFlow;
    User user;

    @BeforeEach
    void setupTest() {
        user = User.builder()
                .name(PropertyLoader.getUserName())
                .email(PropertyLoader.getUserEmail())
                .password(PropertyLoader.getUserPassword())
                .build();

        new MainNotLoggedInPageFlow(driver).clickLogInButton();
        logInPageFlow = new LogInPageFlow(driver);
    }

    @Test
    void verifyLogInAsUser() {
        log.info("We are at Log In form");
        logInPageFlow.performLogInAsUser(user);
        assertThat(new MainLoggedInPageFlow(driver).isCreateNewBoardButtonDisplayed())
                .isTrue();
    }

}
