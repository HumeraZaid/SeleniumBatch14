package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    /*
       Write a program to Go to google.com and maximize the window.
     */

public class maximizeWindow {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create an instance of WebDriver
        WebDriver driver = new ChromeDriver();

        // Go to google.com
        driver.get("https://www.google.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Make it fullscreen
        driver.manage().window().fullscreen();

        // Quit the browser
        // driver.quit();

        // Close the current tab
        driver.close();

    }

}
