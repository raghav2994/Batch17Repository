package org.seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.waitManagerPackage.WaitManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumBasics {

    public static void seleniumDemo() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();
        WebDriver cd = new RemoteWebDriver(new URL("http://192.168.1.13:4444"),options);
        WaitManager wait  = new WaitManager(cd);
        cd.get("https://demo.evershop.io/account/login");

       // wait.implicitWait(5);

        wait.explicitWait(5,By.xpath("//input[@name = 'email']"));

        cd.findElement(By.xpath("//input[@name = 'email']")).sendKeys("akhiljda@gmail.com");
        cd.findElement(By.name("password")).sendKeys("Password");
        cd.findElement(By.xpath("//button[@type = 'submit']")).click();

    }

    public static void main(String[] args) throws MalformedURLException {
        seleniumDemo();
    }

}
