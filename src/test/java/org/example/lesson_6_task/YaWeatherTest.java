package org.example.lesson_6_task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YaWeatherTest {
    WebDriver driver;
    MainPageWeather mainPage;


    @BeforeAll
    static  void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPageWeather(driver);
        driver.get("https://yandex.ru/pogoda/");
    }
    @Test
    void searchForGermanyTest(){
        mainPage.Advertisement()
                .clickElementYaOk()
                .clickSearchForCities("Gers");
//                .ClickCity("Берлин");

        Assertions.assertTrue(driver.getCurrentUrl().contains("0.4099729955"));

    }

    @Test
    void searchForRussian(){
        mainPage.Advertisement()
                .clickElementYaOk()
                .clickSearchForCities("Rus")
                .ClickCity("Ставропольский край");


        Assertions.assertTrue(driver.getCurrentUrl().contains("11069"));
    }



    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
