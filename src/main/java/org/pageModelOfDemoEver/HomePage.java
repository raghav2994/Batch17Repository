package org.pageModelOfDemoEver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    private String homePageUrl = "https://demo.evershop.io/";

    private String itemNameOfHomePage = "//div[@class='listing-tem']//a/span[text()='*#']";

    public HomePage(WebDriver wd) {
        this.driver = wd;
    }


    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void goToHomePage() {
        driver.get(homePageUrl);
    }

    public void selectItemFromHomePage(String itemName) {
        String clickableItemName = itemNameOfHomePage.replace("*#",itemName);
        By itemTextLink = By.xpath(clickableItemName);
        scrollToElement(driver.findElement(itemTextLink));
        driver.findElement(itemTextLink).click();
    }
}
