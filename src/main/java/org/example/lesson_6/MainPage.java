package org.example.lesson_6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BaseView {


    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickSingButton(){
        signInButton.click();
        return new LoginPage(driver);
    }



}
