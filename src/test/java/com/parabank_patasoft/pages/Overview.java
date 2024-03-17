package com.parabank_patasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview extends BasePage{
    public Overview(WebDriver driver) {
        super(driver);
    }
    public boolean isLogout(){
        return getWebElements(By.linkText("Log Out")).size() > 0;
    }
}
