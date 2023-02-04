package me.kornyshev.flow;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import me.kornyshev.pom.MainLoggedInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

@Slf4j
public class MainLoggedInPageFlow extends SeleniumActions {

    MainLoggedInPage mainLoggedInPage;

    public MainLoggedInPageFlow(WebDriver driver) {
        this.driver = driver;
        this.mainLoggedInPage = new MainLoggedInPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Step("Is 'Create New Board' button displayed on Main Page")
    public boolean isCreateNewBoardButtonDisplayed() {
        return wait.until(visibilityOf(mainLoggedInPage.getCreateNewBoardButton())).isDisplayed();
    }

    @Step("Click 'Create New Board' button on Main Page")
    public void clickCreateNewBoardButton() {
        click(mainLoggedInPage.getCreateNewBoardButton());
    }

    @Step("Fill board title field on Board creation modal window")
    public void fillBoardTitleField(String title) {
        setValue(mainLoggedInPage.getBoardTitleFieldOnModalWindow(), title);
    }

    @Step("Click 'Create' button on Board creation modal window")
    public void clickCreateButtonOnModalWindow() {
        click(mainLoggedInPage.getCreateButtonOnModalWindow());
    }

    @Step("Perform Board creation on the Main Page")
    public void performBoardCreationWithTitle(String title) {
        clickCreateNewBoardButton();
        fillBoardTitleField(title);
        clickCreateButtonOnModalWindow();
    }

}
