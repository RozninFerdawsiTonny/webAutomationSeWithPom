package com.parabank_patasoft.testcases;

import com.parabank_patasoft.pages.CustomerLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseTest {

    @Test
    public void CheckLoginPage() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        Assert.assertTrue(loginPage.isLoginPage());

    }
}
