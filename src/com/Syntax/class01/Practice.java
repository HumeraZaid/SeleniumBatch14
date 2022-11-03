package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to google.com
        driver.get("https://www.google.com/");

        // Go to facebook.com
        driver.navigate().to("https://www.facebook.com/");

        Thread.sleep(2000);

        for(int i=0; i<3; i++)
        {
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().forward();
            Thread.sleep(2000);
            driver.navigate().refresh();
        }

        // Quit the browser
        // driver.quit();

        // Close the current tab
        driver.close();
    }
}
