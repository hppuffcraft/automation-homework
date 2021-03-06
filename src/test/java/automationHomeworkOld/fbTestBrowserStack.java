package automationHomeworkOld;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

/**
 * Created by erica.hagle on 8/1/17.
 */

/**
 * This Homework is mainly to implement Selenium webdriver concepts Navigate, Manipulate, Interogate and sync in BrowserStack
 */

// 1. Navigate to FB page
// 2. Interrogate parameters xpath/css for login/password/submit buttons on FB page
// 3. Manipulate - enter some test data within login and password fields
// 4. Sync add some wait time for loading

public class fbTestBrowserStack {
    public static final String USERNAME = "erica.hagle@akqa.com";
    public static final String ACCESS_KEY = "4sjaxUQ1W";
    public static final String URL = "http://" + "erica15" + ":" + "jqjPmMFHG2McxZwPLZVr" + "@hub.browserstack.com/wd/hub";

    private WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser" , "Firefox");
        caps.setCapability("browser_version" , "23.0");
        caps.setCapability("os" , "Windows");
        caps.setCapability("os_version" , "XP");
        caps.setCapability("browserstack.debug" , "true");
        //This enables Visual Logs
        driver = new RemoteWebDriver(new URL(URL), caps);

    }

    @Test (priority = 1)
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

    @Test (priority = 2)
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

    @AfterClass
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

}

