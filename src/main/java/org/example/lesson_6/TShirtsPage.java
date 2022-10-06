package org.example.lesson_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class TShirtsPage extends BaseView{

    public TShirtsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Size']/ancestor::div[@class='layered_filter']//a")
    private List<WebElement> sizesList;

    public TShirtsPage selectSize(String size){
        webDriverWait.until(d -> sizesList.size() > 1);
        sizesList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
        return this;
    }

    @FindBy(xpath = "//div[contains(@class, 'slider')]//a[1]")
    private WebElement leftPriceSliderElement;

    public TShirtsPage moveLeftPriceSliderElement(int pixelsCount){
        actions.clickAndHold(leftPriceSliderElement)
                .moveByOffset(pixelsCount, 0)
                .perform();
        return this;
    }

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> dressesList;

    private static final String addToCartButtonXpathLocator = "//span[.='Add to cart']";

    @FindBy(xpath = addToCartButtonXpathLocator)
    private WebElement addToCartButton;

    public SuccessBlock  addToCartByName(String tshirtName){

        actions.moveToElement(dressesList.stream().filter(d -> d.getText().contains(tshirtName)).findFirst().get())
                        .perform();
        dressesList.stream().filter(d -> d.getText().contains(tshirtName)).findFirst().get().findElement(
                By.xpath(addToCartButtonXpathLocator)).click();
        return new SuccessBlock(driver);
    }
}
