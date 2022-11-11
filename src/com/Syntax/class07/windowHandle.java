package com.Syntax.class07;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandle{

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to the SignUp page on google.com
        driver.get("http://accounts.google.com/signup");

        // Maximize the window
        driver.manage().window().maximize();

        // Get the window handle for the current page
        String gMailHandle = driver.getWindowHandle();

        // Print
        System.out.println("The handle of the current page is: " + gMailHandle);

    }



}
