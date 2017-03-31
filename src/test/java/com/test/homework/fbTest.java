package com.test.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by erica.hagle on 3/21/17.
 */
public class fbTest {
    static String driverPath = "/Users/erica.hagle/Desktop/Automation/chromedriver";
    public static WebDriver driver;
    final static String url = "https://www.facebook.com";

    @BeforeTest
    public static void setupTest() {
        System.out.println("******************");
        System.out.println("Launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void fbLogin() throws IOException {
        //Get page title
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Facebook - Log In or Sign Up"), "Page title doesn't match");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Enter email
        WebElement emailField = driver.findElement(By.xpath("//INPUT[@id='email']"));
        emailField.sendKeys("eehakqa@gmail.com");
        System.out.println("Email entered");

        //Enter password
        WebElement passwordField = driver.findElement(By.xpath("//INPUT[@id='pass']"));
        passwordField.sendKeys("2u#rX7gWfwG#");
        System.out.println("Password entered");

        //Click login button
        WebElement logInButton = driver.findElement(By.xpath("//INPUT[@id='u_0_q']"));
        logInButton.click();
        System.out.println("Logged in");

        //Screenshot
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/erica.hagle/Automation/Screenshots/facebook.png"));
    }

    @AfterTest
    public static void quitDriver() {
        if(driver!=null) {
            System.out.println("Closing Chrome browser");
            driver.quit();
        }
    }

}
