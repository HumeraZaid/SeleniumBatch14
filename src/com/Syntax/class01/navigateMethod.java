package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

        /*
           Write a program to go to google.com, then go to facebook.com, then go back to google.com.
         */

public class navigateMethod {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();  // Create the WebDriver instance
        driver.get("https://www.google.com/");  // Go to google.com

        driver.navigate().to("https://www.facebook.com/");  // Go to facebook.com

        Thread.sleep(2000);  // introduce some sleep, which is wait. Wait or pause for 2000 milliseconds (2 seconds)

        driver.navigate().back();  // Go back to google.com

        Thread.sleep(2000);  // Wait for 2 seconds

        driver.navigate().forward();  // Go back to facebook.com

        Thread.sleep(1000); // Wait for 1 second

        driver.navigate().refresh();  // Refresh the page

      //  driver.quit();  // Quit the browser
        driver.close();

    }
}
