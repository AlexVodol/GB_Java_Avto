package org.example.lesson_6_task;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPageWeather extends BaseViewYandex {
    public MainPageWeather(WebDriver driver) {
        super(driver);
    }



    public CloseTheElement Advertisement(){
        ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//div[@class='content__right']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n"+
                "element.singleNodeValue.remove()");
        return new CloseTheElement(driver);
    }

}
