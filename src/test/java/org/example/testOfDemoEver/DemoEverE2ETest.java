package org.example.testOfDemoEver;

import org.excelManagerPackage.ExcelManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.pageModelOfDemoEver.HomePage;
import org.pageModelOfDemoEver.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.webDriverUtilities.WebDriverManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DemoEverE2ETest {

    ChromeOptions chromeOptions;
    FirefoxOptions firefoxOptions;
    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browserName) throws MalformedURLException {
        switch(browserName){
            case "chrome": {
                chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.1.13:4444"), chromeOptions);
                WebDriverManager.setDriver(driver);
                break;
            }
            case "firefox": {
                firefoxOptions = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.1.13:4444"), firefoxOptions);
                WebDriverManager.setDriver(driver);
                break;
            }
            default:
                chromeOptions = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://192.168.1.13:4444"), chromeOptions);
                WebDriverManager.setDriver(driver);
                break;
        }
    }

//    @DataProvider(name = "LoginData")
//    public Object[][] getLoginData() throws IOException {
//        return ExcelManager.getData();
//    }

    @Test(description = "Verify E2E is working fine", groups = {"Sanity"})
    public void verifyE2EIsWorking() throws InterruptedException {
        WebDriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.hitTheUrl("https://demo.evershop.io/account/login")
                .fillCredentials("akhiljda@gmail.com","Password")
                .clickLoginButton();
        Thread.sleep(3000);
        homePage.selectItemFromHomePage("Nike zoom fly");
    }

    @Test(description = "Verify E2E is working fine")
    public void verifyE2EIsWorkingSecond() throws InterruptedException {
        WebDriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.hitTheUrl("https://demo.evershop.io/account/login")
                .fillCredentials("akhiljda@gmail.com","Password")
                .clickLoginButton();
    }



}
