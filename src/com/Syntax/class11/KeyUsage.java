package com.Syntax.class11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class KeyUsage {

        public static void main(String[] args) throws InterruptedException {
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

            // Introduce some sleep to observe the change
            Thread.sleep(3000);

            // Password field
            WebElement pass = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
            pass.sendKeys("test",Keys.ENTER);
    }

}
