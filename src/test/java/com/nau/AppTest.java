package com.nau;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest {

    WebDriver driver;


    /**
     * Set up Driver, initialize driver, navigate to the app and maximize window.
     */
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String appUrl = "http://zero.webappsecurity.com/login.html";
        driver.get(appUrl);
        driver.manage().window().maximize();
    }

    /**
     * Log into the application.
     */
    @Test(priority = 1)
    public void loginTest() {
        WebElement login = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_password"));
        WebElement submit = driver.findElement(By.name("submit"));

        login.clear();
        login.sendKeys("username");
        password.sendKeys("password");
        submit.click();
    }

    /**
     * Verify Home page title is Zero Bank
     */
    @Test(priority = 2)
    public void homePageTest() {
        WebElement title = driver.findElement(By.xpath("//a[.='Zero Bank']"));
        String homePageTitle = title.getText();
        Assert.assertEquals(homePageTitle, "Zero Bank", "Home page title is wrong");
    }

    /**
     * Verify Home page has Cash Accounts section
     */
    @Test(priority = 3)
    public void cashAccountTest() {
        WebElement accounts = driver.findElement(By.xpath("//h2[.='Cash Accounts']"));
        String cashAccounts = accounts.getText();
        Assert.assertEquals(cashAccounts, "Cash Accounts", "Cash Accounts is missing");
    }

    /**
     * Verify Home page has Investment Accounts section
     */
    @Test(priority = 4)
    public void investmentAccountTest() {
        WebElement accounts = driver.findElement(By.xpath("//h2[.='Investment Accounts']"));
        String investmentAccounts = accounts.getText();
        Assert.assertEquals(investmentAccounts, "Investment Accounts", "Investment Accounts is missing");
    }

    /**
     * Verify Home page has Credit Accounts section
     */
    @Test(priority = 5)
    public void creditAccountTest() {
        WebElement accounts = driver.findElement(By.xpath("//h2[.='Credit Accounts']"));
        String creditAccounts = accounts.getText();
        Assert.assertEquals(creditAccounts, "Credit Accounts", "Credit Accounts is missing");
    }

    /**
     * Verify Home page has Loan Accounts section
     */
    @Test(priority = 6)
    public void loanAccountTest() {
        WebElement accounts = driver.findElement(By.xpath("//h2[.='Loan Accounts']"));
        String loanAccounts = accounts.getText();
        Assert.assertEquals(loanAccounts, "Loan Accounts", "Loan Accounts is missing");
    }

    /**
     * Quite driver after test execution
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}