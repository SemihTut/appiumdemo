package automation;





import java.net.URL;
import java.util.function.Function;
import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

    public class ifLappen {

        public static void main(String[] args) throws MalformedURLException, InterruptedException {

            DesiredCapabilities caps = new DesiredCapabilities();

            // Set your access credentials
            caps.setCapability("browserstack.user", "semihtut1");
            caps.setCapability("browserstack.key", "wf3fBrZGCzB5Vsnp7TWo");

            // Set URL of the application under test
            caps.setCapability("app", "bs://027637d2ffe5c2aca1c4fe77c08572e0929b17c4");

            // Specify device and os_version for testing
            caps.setCapability("device", "Samsung Galaxy Tab S7");
            caps.setCapability("os_version", "10.0");

            // Set other BrowserStack capabilities
            caps.setCapability("project", "First Java Project");
            caps.setCapability("build", "Java Android");
            caps.setCapability("name", "first_test");


            // Initialise the remote Webdriver using BrowserStack remote URL
            // and desired capabilities defined above
            AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);


            /* Write your Custom code here */


            // Invoke driver.quit() after the test is done to indicate that the test is completed.
            driver.quit();

        }

    }

