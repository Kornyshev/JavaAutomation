package me.kornyshev.pom.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BoardCardOnMainPage {

    private final WebElement root;

    public BoardCardOnMainPage(WebElement root) {
        this.root = root;
    }

    public String getTitle() {
        return root.findElement(By.xpath(".//div[@class='board-tile-details-name']")).getText();
    }

    public void hover() {
        throw new UnsupportedOperationException();
    }

    public void clickStarIcon() {
        throw new UnsupportedOperationException();
    }

}
