package org.pageModelOfDemoEver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By userNameField = By.xpath("//input[@name = 'email']");
    private By passwordField = By.xpath("//input[@name = 'password']");
    private By submitButtonField = By.xpath("//button[@type = 'submit']");


    public LoginPage(WebDriver wd) {
        this.driver = wd;
    }

    public LoginPage hitTheUrl(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillCredentials(String username, String password) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(submitButtonField).click();
        return this;
    }

}
