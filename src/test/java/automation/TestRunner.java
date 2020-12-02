package automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class TestRunner {
    private AppiumDriver<MobileElement> driver;

    @Test
    public void test() throws InterruptedException {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
            desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\etsy.apk");
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20000);
            driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
            Thread.sleep(3000);
            WebElement getStarted = driver.findElement(By.xpath("//*[@text='Get Started']"));
             getStarted.click();
            Thread.sleep(3000);
           //-----------------------------------------------------

            
           /* driver.findElement(MobileBy.AndroidUIAutomator( String.format("new UiSelector().description(\"%s\")", "Home"))).click();
            driver.findElement(MobileBy.AndroidUIAutomator(
                    String.format("new UiSelector().description(\"%s\")", "My Ads"))).click();*/


           /* WebElement email = driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
            String semih = Keys.chord("semih");
            email.sendKeys(semih);

            WebElement password = driver.findElement(By.xpath("(//android.widget.EditText)[2]"));
            password.sendKeys(semih+semih);*/

           /* WebElement withGoogle = driver.findElement(By.xpath("(//android.widget.Button)[2]"));
            withGoogle.click();
            WebElement email2 = driver.findElement(By.xpath("(//android.widget.EditText)[1]"));
            password.sendKeys(semih+semih);
            email2.sendKeys("yalaantv@gmail.com");
            WebElement next = driver.findElement(By.xpath("(//android.widget.Button)[1]"));
            withGoogle.click();*/


          /*  List<MobileElement> footerMenu = driver.findElementsByClassName("android.widget.TextView");
            for (MobileElement menu : footerMenu) {
                System.out.println("menu.getText() = " + menu.getText());
            }
            int size = footerMenu.size();
            System.out.println("size = " + size);*/
            //---------------------------------------------------
           /* WebElement ok = driver.findElement(By.className("android.widget.ImageView"));

            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOf(ok));
            ok.click();*/
           // driver.(new KeyEvent(AndroidKey.HOME));

            driver.closeApp();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
