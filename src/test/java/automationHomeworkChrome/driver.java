package automationHomeworkChrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class driver  {
    static String driverPath = "/Users/erica.hagle/Desktop/Automation/chromedriver";
    public static WebDriver driver;
    final static String url = "https://www.facebook.com";

    @BeforeClass
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
    }

    @AfterClass
    public static void quitDriver() {
        if (driver != null) {
            System.out.println("Closing Chrome browser");
            driver.quit();
        }
    }

}
