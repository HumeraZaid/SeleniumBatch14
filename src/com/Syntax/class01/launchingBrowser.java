package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

        /*
            Write a program to go to google.com and get the current URL and title of that URL.
         */

public class launchingBrowser {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Use the get() function to open up the required website
        driver.get("https://www.google.com/");

        // Get the URL of the website
        String url = driver.getCurrentUrl();

        // Print the URL
        System.out.println(url);

        // Get the title of the website
        String title = driver.getTitle();

        // Print the title
        System.out.println(title);

        // Quit the Chrome browser
        // driver.quit();

        // Close the current tab
        driver.close();

    }
}
