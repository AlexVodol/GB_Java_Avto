package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Afisha {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.afisha.ru/stavropol/");

        WebElement inputSearch = driver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']"));
        inputSearch.sendKeys("Брат");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[.='Брат']"))));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Брат']")));

        driver.findElement(By.xpath("//div[.='Брат']")).click();

        Thread.sleep(5000);

        driver.quit();

    }
}
