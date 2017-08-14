package automationHomeworkBrowserStack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;

public class driver {

    public static final String USERNAME = "erica.hagle@akqa.com";
    public static final String ACCESS_KEY = "4sjaxUQ1W";
    public static final String URL = "http://" + "erica15" + ":" + "jqjPmMFHG2McxZwPLZVr" + "@hub.browserstack.com/wd/hub";

    public WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "23.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "XP");
        caps.setCapability("browserstack.debug", "true");
        //This enables Visual Logs
        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

}
