package com.Syntax.class11;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenShot {

    public static void main(String[] args) throws IOException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Go to the website
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        // Username textbox
        WebElement userName = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']"));
        userName.sendKeys("Tester", Keys.TAB);

        // Enter the password
        WebElement passWord = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passWord.sendKeys("test", Keys.ENTER);

        // Take a screenshot
        TakesScreenshot ss= (TakesScreenshot)driver;

        // Screenshot is taken at this point
        File sourceFile = ss.getScreenshotAs(OutputType.FILE);

        // Save the file from your variable into the location into your computer
        // FileUtils.copyFile(sourceFile,new File("screenshots/SmartBear/adminLogin.png"));
        // FileUtils.copyFile(sourceFile,new File("screenshots/SmartBear/adminLogin123.png"));
        FileUtils.copyFile(sourceFile,new File("ss/myscreenshots/abc.png"));
    }
}
