package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.utils.ExcelUtils;
import com.example.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({TestListener.class })
public class LoginPageTests extends BaseTests{

    String actualResponse;

    @BeforeTest
    public void setupTestData() throws IOException {

        System.out.println("Setup Test Data");
        ExcelUtils.setExcelFileSheet("LoginData");
    }

    @Test
    public void invalidCredentials() throws IOException {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(ExcelUtils.getCellData(1,1), ExcelUtils.getCellData(1,2));
        actualResponse = objLoginPage.getErrorMessage();
        ExcelUtils.setCellData(actualResponse,1,4);
        objLoginPage.saveTestResults(1,5);
        Assert.assertEquals(actualResponse,ExcelUtils.getCellData(1,3));
    }

    @Test
    public void missingUsername() throws IOException {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(ExcelUtils.getCellData(2,1), ExcelUtils.getCellData(2,2));
        actualResponse = objLoginPage.getMissingUsernameText();
        ExcelUtils.setCellData(actualResponse,2,4);
        objLoginPage.saveTestResults(2,5);
        Assert.assertEquals(actualResponse,ExcelUtils.getCellData(2,3));
    }

    @Test
    public void missingPassword() throws IOException {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(ExcelUtils.getCellData(3,1), ExcelUtils.getCellData(3,2));
        actualResponse = objLoginPage.getMissingPasswordText();
        ExcelUtils.setCellData(actualResponse,3,4);
        objLoginPage.saveTestResults(3,5);
        Assert.assertEquals(actualResponse,ExcelUtils.getCellData(3,3));

    }

    //Fail this test
    @Test
    public void validCredentials() throws IOException {

        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.login(ExcelUtils.getCellData(4,1), ExcelUtils.getCellData(4,2));
        HomePage objHomePage = new HomePage(driver);
        actualResponse = objHomePage.getHomePageText();
        ExcelUtils.setCellData(actualResponse,4,4);
        objLoginPage.saveTestResults(4,5);
        Assert.assertEquals(actualResponse,ExcelUtils.getCellData(4,3));

    }

}
