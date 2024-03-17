package com.parabank_patasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver); // Super means parent class
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By Locator) {
        WebElement webElement = null;
        try {
            waitForWebElement(Locator);
            webElement = driver.findElement(Locator);

        } catch (Exception exception) {
            System.out.println(Locator.toString() + "Selector or Locator Not Found");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By Selector) {
        List<WebElement> webElements = null;
        try {
            waitForWebElement(Selector);
            webElements = driver.findElements(Selector);
        } catch (Exception exception) {
            System.out.println(Selector.toString() + "Selector or Locator Not Found");
        }
        return webElements;
    }

    @Override
    public void waitForWebElement(By Locator) {
        try {

        } catch (Exception exception) {
            System.out.println(Locator.toString() + "Selector or Locator Not Found");
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(Locator));

    }
}
