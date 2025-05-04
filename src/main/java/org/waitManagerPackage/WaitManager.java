package org.waitManagerPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    public WebDriver driver;

    public WebDriverWait wait;

    public Wait fluentWait;

    public WaitManager(WebDriver wd) {
        this.driver = wd;
    }

    public void implicitWait(int timeout) {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));

    }

    public void explicitWait(int timeout, By locator) {
        wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void fluentWait(int timeout, By locator, int pollTime) {

        fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollTime))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
