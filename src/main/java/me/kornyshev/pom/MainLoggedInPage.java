package me.kornyshev.pom;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class MainLoggedInPage {

    private final WebDriver driver;

    @FindBy(css = "nav button[data-testid='header-create-menu-button']")
    private WebElement createButton;
    @FindBy(xpath = "//div[@class='boards-page-board-section-header']/following-sibling::div//span[contains(text(), 'Create new board')]/ancestor::div[1]")
    private WebElement createNewBoardButton;
    @FindBy(css = "section form input[data-testid='create-board-title-input']")
    private WebElement boardTitleFieldOnModalWindow;
    @FindBy(css = "section form button[data-testid='create-board-submit-button']")
    private WebElement createButtonOnModalWindow;
    @FindBy(xpath = "//div[@class='boards-page-board-section-header']/following-sibling::div//li[@class='boards-page-board-section-list-item']/a")
    private List<WebElement> createdBoardsElements;

    public MainLoggedInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
