package tests;

import lombok.extern.slf4j.Slf4j;
import me.kornyshev.flow.LogInPageFlow;
import me.kornyshev.flow.MainLoggedInPageFlow;
import me.kornyshev.flow.MainNotLoggedInPageFlow;
import me.kornyshev.models.User;
import me.kornyshev.properties.PropertyLoader;
import me.kornyshev.utils.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BoardTests extends BaseTests {

    MainLoggedInPageFlow mainLoggedInPageFlow;
    User user;

    @BeforeEach
    void setupTest() {
        user = User.builder()
                .name(PropertyLoader.getUserName())
                .email(PropertyLoader.getUserEmail())
                .password(PropertyLoader.getUserPassword())
                .build();

        new MainNotLoggedInPageFlow(driver).clickLogInButton();
        new LogInPageFlow(driver).performLogInAsUser(user);
        mainLoggedInPageFlow = new MainLoggedInPageFlow(driver);
    }

    @Test
    void verifyBoardsCreation() {
        String board1 = "Board" + DataUtils.timestamp();
        String board2 = "Board" + DataUtils.timestamp();
        mainLoggedInPageFlow.performBoardCreationWithTitle(board1);
        mainLoggedInPageFlow.navigateBack();
        mainLoggedInPageFlow.performBoardCreationWithTitle(board2);
        mainLoggedInPageFlow.navigateBack();
        assertThat(mainLoggedInPageFlow.getCreatedBoardsFromPage()).containsAll(List.of(board1, board2));
    }

}
