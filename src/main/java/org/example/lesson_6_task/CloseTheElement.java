package org.example.lesson_6_task;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloseTheElement extends BaseViewYandex {

    @FindBy(xpath = "//a[contains(text(), 'Закрыть')]")
    private WebElement ElementYaOk;

    public CloseTheElement(WebDriver driver) {
        super(driver);
    }

    public SearchStringOfCities clickElementYaOk(){
        ElementYaOk.click();
        return new SearchStringOfCities(driver);
    }
}
