package com.simple.Calculator;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.codec.binary.Base64;


public class BaseTest {
 AndroidDriver driver ;

            @BeforeClass
            public void launchApp() {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("udid", "FEGEZTS8T4LNBI7L");
                capabilities.setCapability("platformVersion", "13");
                capabilities.setCapability("deviceName", "narzo 50");
                capabilities.setCapability("appPackage", "com.coloros.calculator");
                capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
                capabilities.setCapability("noReset", "true");
                try {
                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                    driver.startRecordingScreen();
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }
            @AfterClass
            public void closeApp() {
                recordingVideo();
                driver.quit();
            }

    public void takeScreenshot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir") + "/build/screenshots/";
            FileUtils.copyFile(scrFile, new File(currentDir + System.currentTimeMillis()+ ".jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void recordingVideo() {
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = System.getProperty("user.dir") + "/build/videos";
        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
