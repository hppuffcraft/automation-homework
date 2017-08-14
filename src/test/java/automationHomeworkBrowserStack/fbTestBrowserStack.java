package automationHomeworkBrowserStack;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class fbTestBrowserStack extends automationHomeworkBrowserStack.driver {

    @Test(priority = 0)
    public void fbLogin() throws IOException {
        driver.manage().window().maximize();

        //Navigate
        driver.get("https://www.facebook.com");

        //Sync
        WebDriverWait wait = new WebDriverWait(driver, 20);

        //Get page title
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Facebook - Log In or Sign Up"), "Page title doesn't match");

        //Screenshot
        File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_launch.png"));

        //Enter email = Manipulate + Interrogate
        WebElement emailField = driver.findElement(By.xpath("//INPUT[@id='email']"));
        emailField.sendKeys("eehakqa@gmail.com");
        System.out.println("Email entered");

        //Screenshot
        File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_email.png"));

        //Enter password
        WebElement passwordField = driver.findElement(By.xpath("//INPUT[@id='pass']"));
        passwordField.sendKeys("2u#rX7gWfwG#");
        System.out.println("Password entered");

        //Screenshot
        File scrFile3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile3, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_password.png"));

        //Click login button
        WebElement logInButton = driver.findElement(By.id("loginbutton"));
        logInButton.click();
        System.out.println("Logged in");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Screenshot
        File scrFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile4, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_login.png"));
    }

    @Test (priority = 1)
    public void fbLogOut() throws IOException {

        //Open navigation drop down menu
        WebElement lstitem = driver.findElement(By.id("userNavigationLabel"));
        lstitem.click();

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Select log out option
        driver.findElement(By.partialLinkText("Log Out")).click();
        System.out.println("Logged out");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Screenshot
        File scrFile5 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile5, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_logout.png"));

    }
}
