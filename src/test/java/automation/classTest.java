package automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;
import java.net.URL;

public class classTest {
    private AppiumDriver<MobileElement> driver;
   /* @FindBy(id = "com.android.calculator2:id/digit_3")
    WebElement three;*/


    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //we use android phone
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //version of android
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION, "8.0");
        //name of the device, if it is real device we need to pass UUID parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");

        //either you specify app--> //path/to/app.apk
        //or if app is already installed, you need to specify appActivity and appPackage
        //this info you can find in the internet, at work - ask to developers

        // Set your application's package name.
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");

        // Set your application's MainActivity i.e. the LAUNCHER activity name.

        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

            driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(2000);



/*
        WebElement one = driver.findElement(By.id("com.android.calculator2:id/digit_1"));
        one.click();
        Thread.sleep(500);

        WebElement eight = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        eight.click();
        Thread.sleep(500);

        WebElement three = driver.findElement(By.id("com.android.calculator2:id/digit_3"));
        three.click();
        Thread.sleep(500);

        WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        seven.click();
        Thread.sleep(500);

        eight.click();
        Thread.sleep(500);
        three.click();
        Thread.sleep(500);
        seven.click();

        WebElement del = driver.findElement(By.xpath("//*[text='DEL'])"));
        WebElement multiply = driver.findElement(By.id("com.android.calculator2:id/op_mul"));


*/
        WebElement eight = driver.findElement(By.id("com.android.calculator2:id/digit_8"));
        WebElement seven = driver.findElement(By.id("com.android.calculator2:id/digit_7"));
        WebElement multiply = driver.findElement(By.id("com.android.calculator2:id/op_mul"));
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        WebElement equal = driver.findElement(By.id("com.android.calculator2:id/eq"));

        Thread.sleep(1000);

        seven.click();
        multiply.click();
        eight.click();
        equal.click();
        Thread.sleep(3000);
        String expectedResult = result.getText();
        System.out.println("expectedResult = " + expectedResult);

        Assert.assertEquals(expectedResult,"56");

       Thread.sleep(1000);



            driver.closeApp();

    }
}