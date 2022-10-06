package org.example.lesson_6_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseViewYandex {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Actions actions;

    public BaseViewYandex(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this );
    }
}
