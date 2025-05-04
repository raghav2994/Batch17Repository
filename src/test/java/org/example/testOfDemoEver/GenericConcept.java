package org.example.testOfDemoEver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GenericConcept {



    ChromeOptions chromeOptions;
    WebDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        chromeOptions = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://172.24.90.105:4444"), chromeOptions);
    }

//    @BeforeMethod
//    public void preMethodSteps() {
//        driver.get("https://selectorshub.com/xpath-practice-page/");
//    }
//
//    @Test
//    public void alertTest() throws InterruptedException {
//        Thread.sleep(4000);
//        driver.findElement(By.xpath("//button[@onclick='windowAlertFunction()']")).click();
//        System.out.println(driver.switchTo().alert().getText());
//        Thread.sleep(4000);
//        driver.switchTo().alert().accept();
//    }

    @Test
    public void iFrameConcept(){

        driver.get("https://selectorshub.com/iframe-scenario/");
        driver.switchTo().frame("pact1");
        driver.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Raghav");
        driver.switchTo().frame("pact2");
        driver.findElement(By.xpath("//input[@id='jex']")).sendKeys("Rashika");
        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//input[@id='inp_val']")).clear();
        driver.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Aman");





    }



}
