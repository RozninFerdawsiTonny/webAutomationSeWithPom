package com.parabank_patasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage{
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }
    public CustomerLoginPage fillUsername(String username){
        getWebElement(By.cssSelector("input[name='username']")).sendKeys(username);
        return this;

    }
    public CustomerLoginPage fillPassword(String password){
        getWebElement((By.cssSelector("input[name='password']"))).sendKeys(password);
        return this;
    }
    public Overview clickLoginBtn(){
        getWebElement(By.cssSelector("input[class='button']")).click();
        return getInstance(Overview.class);

    }
    public boolean isLoginPage(){
        return getWebElements(By.cssSelector("from[name='login']")).size()>0;
    }
}
