package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

        /*
           Write a program to go to google.com, then go to facebook.com, then go back to google.com.
         */

public class navigateMethod {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to google.com
        driver.get("https://www.google.com/");

        // Go to facebook.com
        driver.navigate().to("https://www.facebook.com/");

        // introduce some sleep, which is wait. Wait or pause for 2000 milliseconds (2 seconds)
        Thread.sleep(2000);

        // Go back to google.com
        driver.navigate().back();

        // Wait for 2 seconds
        Thread.sleep(2000);

        // Go back to facebook.com
        driver.navigate().forward();

        // Wait for 1 second
        Thread.sleep(1000);

        // Refresh the page
        driver.navigate().refresh();

        // Quit the browser
        // driver.quit();

        // Close the current tab
        driver.close();

    }
}
