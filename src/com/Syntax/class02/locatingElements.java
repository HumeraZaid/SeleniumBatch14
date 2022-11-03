package com.Syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locatingElements {

    /*
       Task 1:
       Go to fb.com.
       Enter username.
       Enter password.
       Click on login.
     */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to fb.com
        driver.get("https://www.facebook.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Enter the username in the textbox. Locate the element and send the keys
        driver.findElement(By.id("email")).sendKeys("abracadbara");

        // Enter the password in the text box
        driver.findElement(By.name("pass")).sendKeys("waow12345678");

        // Click on login
        driver.findElement(By.name("login")).click();

        // For the following task to work, please make sure that you comment the login functionality.

        /*
           Task 2:
           Click on Forgot Password?.
         */

        // driver.findElement(By.linkText("Forgot password?")).click();

        /*
           Task 3:
           click on forgot password using partial linkText locator.
         */

        //  driver.findElement(By.partialLinkText("Forgot")).click();

    }
}
