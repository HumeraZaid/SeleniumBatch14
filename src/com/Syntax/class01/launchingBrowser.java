package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

        /*
            Write a program to go to google.com and get the current URL and title of that URL.
         */

public class launchingBrowser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");  // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("https://www.google.com/");  // Use the get() function to open up the required website

        String url = driver.getCurrentUrl(); // Get the URL of the website
        System.out.println(url);      // Print the URL

        String title = driver.getTitle();  // Get the title of the website
        System.out.println(title);  // Print the title

        driver.quit(); // Quit the Chrome browser

    }
}
