package org.example.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationBlock extends BaseView {

    public NavigationBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li/a[.='Women']")
    private WebElement womenButton;

    @FindBy(xpath = "//ul[contains(@class, 'submenu')]//a[.='T-shirts']")
    private WebElement tShirtsButtonSubmenu;

    public TShirtsPage  hoverWomenMenuAndClickTShirts(){

        webDriverWait.until(ExpectedConditions.visibilityOf(womenButton));
        actions.moveToElement(womenButton)
                .perform();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(tShirtsButtonSubmenu));
        tShirtsButtonSubmenu.click();
        return new TShirtsPage(driver);
    }
}
