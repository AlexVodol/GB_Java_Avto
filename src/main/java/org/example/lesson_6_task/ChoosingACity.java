package org.example.lesson_6_task;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChoosingACity extends BaseViewYandex {
    public ChoosingACity(WebDriver driver) {
        super(driver);
    }




    public void ClickCity(String FullNameOfCityINRussian){
        driver.findElement(By.xpath("//a[text()='"+FullNameOfCityINRussian +"']")).click();
    }

}
