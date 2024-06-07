package com.example.utils;

import com.example.tests.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I am in onStart method :" + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method :" + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method :" + getTestMethodName(iTestResult) + ": start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult)  {
        System.out.println("I am in onTestSuccess method :" + getTestMethodName(iTestResult) + ": succeed");
        try {
            ExcelUtils.setCellData("PASSED", ExcelUtils.rowNumber, ExcelUtils.columnNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult)  {
        System.out.println("I am in onTestFailure method :" + getTestMethodName(iTestResult) + " failed");
        //Update the test result on excel sheet
        try {
            ExcelUtils.setCellData("FAILED", ExcelUtils.rowNumber, ExcelUtils.columnNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method :" + getTestMethodName(iTestResult) + ": skipped");
        //Update the test result on excel sheet
        try {
            ExcelUtils.setCellData("SKIPPED", ExcelUtils.rowNumber, ExcelUtils.columnNumber);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
