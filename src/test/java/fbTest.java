import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by erica.hagle on 3/31/17.
 */
public class fbTest {
    static String driverPath = "/Users/erica.hagle/automation-homework/chromedriver";
    public static WebDriver driver;
    final static String url = "https://www.facebook.com";

    @BeforeTest
    public static void setupTest() {
        System.out.println("******************");
        System.out.println("Launching Chrome browser");
        System.setProperty("webdriver.chrome.driver", driverPath);

        // Create object of HashMap Class
        Map<String, Object> prefs = new HashMap<String, Object>();

        // Set the notification setting it will override the default setting
        prefs.put("profile.default_content_setting_values.notifications", 2);

        // Set the password saver setting it will override the default setting
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        // Create object of ChromeOption class
        ChromeOptions options = new ChromeOptions();

        // Set the experimental option
        options.setExperimentalOption("prefs", prefs);

        // Add "options" to new ChromeDriver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void fbLogin() throws IOException {
        //Get page title
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: "+strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("Facebook - Log In or Sign Up"), "Page title doesn't match");

        //Screenshot
        File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile1, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_launch.png"));

        //Enter email
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
        WebElement logInButton = driver.findElement(By.xpath("//INPUT[@id='u_0_q']"));
        logInButton.click();
        System.out.println("Logged in");

        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Screenshot
        File scrFile4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile4, new File("/Users/erica.hagle/automation-homework/screenshots/facebook_login.png"));
    }

    @AfterTest
    public static void quitDriver() {
        if(driver!=null) {
            System.out.println("Closing Chrome browser");
            driver.quit();
        }
    }

}
