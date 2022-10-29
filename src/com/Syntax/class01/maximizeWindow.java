package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

    /*
       Write a program to Go to google.com and maximize the window.
     */

public class maximizeWindow {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();  // Create an instance of WebDriver
        driver.get("https://www.google.com/");  // Go to Google.com

        driver.manage().window().maximize();  // Maximize the window

        driver.manage().window().fullscreen(); // Make the screen full
      //  driver.quit();  // Quit the browser
        driver.close();
    }

}
