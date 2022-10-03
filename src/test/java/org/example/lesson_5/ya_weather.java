package org.example.lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ya_weather {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://yandex.ru/pogoda/");
        }

        @Test
        void searchForGermany()  {
            ((JavascriptExecutor)driver).executeScript("let element = document.evaluate(\"//div[@class='content__right']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n"+
                    "element.singleNodeValue.remove()");

            driver.findElement(By.xpath("//a[contains(text(), 'Закрыть')]")).click();

            driver.findElement(By.xpath("//input[@placeholder='Город или район']")).click();
            actions.sendKeys("Ger")
                    .perform();

            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@data-text=\"Germany\"]/a")));
            actions.moveToElement(driver.findElement(By.xpath("//li[@data-text=\"Germany\"]/a")))
                    .click()
                    .perform();

            Assertions.assertTrue(driver.getCurrentUrl().contains("96"));

        }

        @Test
        void weatherComparison(){
        driver.findElement(By.xpath("//a[@data-s-text='На месяц']")).click();
        driver.findElement(By.xpath("//div[@class=\"header-title__buttons header-title__buttons_theme_gray\"]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Перейти к сравнению')]")).click();
        driver.findElement((By.xpath("//input[@placeholder=\"Добавьте город\"]"))).click();

        actions.sendKeys("T")
                .perform();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class=\"suggest2-item__link\"]")));
        driver.findElement(By.xpath("//a[@class=\"suggest2-item__link\"]")).click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("lon=41.969111"));

    }


    @AfterEach
    void tearDown(){
        driver.quit();
    }



}
