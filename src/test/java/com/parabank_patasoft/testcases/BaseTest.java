package com.parabank_patasoft.testcases;

import com.parabank_patasoft.pages.BasePage;
import com.parabank_patasoft.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    private Properties properties; //config.properties

    public BaseTest() {
        String pathpath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(pathpath); //file theke data read
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void setupBrowser() {
        String browserName = properties.getProperty("browserName");
        if (Objects.equals(browserName, "chrome")) {
            // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (Objects.equals(browserName, "firefox")) {
            // WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Objects.equals(browserName, "headless")) {
            // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            System.out.println("Provide correct browsername");
        }
        driver.manage().window().maximize();
        driver.get(properties.getProperty("baseUrl"));
        page = new BasePage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();

    }

    public String getUsername() {

        return properties.getProperty("username");
    }

    public String getPassword() {

        return properties.getProperty("password");
    }

}

