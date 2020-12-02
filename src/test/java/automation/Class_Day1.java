package automation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Class_Day1 {

    AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //we use android phone
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        //version of android
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8.0");
        //name of the device, if it is real device we need to pass UUID parameter
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");

        //either you specify app--> //path/to/app.apk
        //or if app is already installed, you need to specify appActivity and appPackage
        //this info you can find in the internet, at work - ask to developers

        // Set your application's package name.
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");

        // Set your application's MainActivity i.e. the LAUNCHER activity name.
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        /*"http://localhost:4723/wd/hub" --> address of the appium server. If you have appium server on the same computer
        just use local host
        4723-->default port number
        //we need to provide 2 parameters: URL of appium servers and desired capabilities

        */
        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);

        Thread.sleep(3000);

        //TEST 2+2 is returing 4
        MobileElement digit2 = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        //mobileBy child class of by
        MobileElement plus = driver.findElement(MobileBy.AccessibilityId("plus"));
        MobileElement equals = driver.findElement(MobileBy.AccessibilityId("equals"));
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));

        digit2.click();
        plus.click();
        digit2.click();
        equals.click();

        //get the text of mobile element of result
        String resultText = result.getText();

        Assert.assertEquals(resultText,"4");
        Thread.sleep(2000);

        //verify 4 * 5 = 20
        MobileElement digit4 = driver.findElement(By.id("com.android.calculator2:id/digit_4"));
        MobileElement digit5 = driver.findElement(By.id("com.android.calculator2:id/digit_5"));
        MobileElement multipy = driver.findElementByAccessibilityId("multiply");

        digit4.click();
        multipy.click();
        digit5.click();
        equals.click();

        resultText = result.getText();
        //verify result is keeping 20
        Assert.assertEquals(resultText,"20");

        //close the app at the end
        driver.closeApp();

    }
    @Test
    public void test2() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.VERSION,"8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_2");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");

        //another way to reach the etsy
        desiredCapabilities.setCapability("app","https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        driver = new AppiumDriver<>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities);
        Thread.sleep(5000);





        driver.closeApp();


    }


    public static void calculator(String digit1 , String digit2, String operation, String expectedResult) {
        AppiumDriver<MobileElement> driver = null;
        driver.findElement(By.id("com.android.calculator2:id/digit_" + digit1)).click();
        driver.findElement(MobileBy.AccessibilityId(operation)).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_" + digit2)).click();
        driver.findElement(MobileBy.AccessibilityId("equals")).click();
        MobileElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        result.click();
        String resultTest = result.getText();
        Assert.assertEquals(resultTest, expectedResult);

    }
    public MobileElement clickDigits(int num){
        String xpath ="com.android.calculator2:id/digit_"+num;
        return driver.findElement(By.id(xpath));
    }
}
