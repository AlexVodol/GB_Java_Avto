package org.example.lesson_6_task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchStringOfCities extends BaseViewYandex {
    public SearchStringOfCities(WebDriver driver) {
        super(driver);
    }


    private final static String SearchForCitiesXpLocator = "//input[@placeholder='Город или район']";

   private final static String FirstOneMatchesXpLocator = "//li[@data-index= '0']";

    public ChoosingACity clickSearchForCities(String CountryOrCity){
        actions.moveToElement(driver.findElement(By.xpath(SearchForCitiesXpLocator)))
                .click()
                .sendKeys(CountryOrCity)
                .perform();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FirstOneMatchesXpLocator)));
        actions.moveToElement(driver.findElement(By.xpath(FirstOneMatchesXpLocator)))
                .click()
                .perform();
        return new ChoosingACity(driver);
    }
}
