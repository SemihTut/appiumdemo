package automation;





import java.net.URL;
import java.util.function.Function;
import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

    public class ifLappen {

        private AppiumDriver<MobileElement> driver;
        @Test
        public void test1() throws MalformedURLException, InterruptedException {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Set your access credentials
            caps.setCapability("browserstack.user", "semihtut1");
            caps.setCapability("browserstack.key", "wf3fBrZGCzB5Vsnp7TWo");

            // Set URL of the application under test
            caps.setCapability("app", "bs://9e6671f026c226f00c00b4a1bb8c5fdac66fa850");

            // Specify device and os_version for testing
            caps.setCapability("device", "Google Pixel 2");
            caps.setCapability("os_version", "8.0");

            // Set other BrowserStack capabilities
            caps.setCapability("project", "IF Lappen Project");
            caps.setCapability("build", "Java Android");
            caps.setCapability("name", "Installing Test");


            // Initialise the remote Webdriver using BrowserStack remote URL
            // and desired capabilities defined above
            driver = new AppiumDriver<MobileElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);


            /* Write your Custom code here */


            // Invoke driver.quit() after the test is done to indicate that the test is completed.
            driver.quit();

        }

    }