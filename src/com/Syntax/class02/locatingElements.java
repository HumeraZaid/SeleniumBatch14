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
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("https://www.facebook.com/");  // Go to fb.com

        driver.manage().window().maximize();  // Maximize the window

        driver.findElement(By.id("email")).sendKeys("abracadbara");  // Enter the username in the text box. Locate the element and send the keys.
        driver.findElement(By.name("pass")).sendKeys("waow12345678"); // Enter the password in the text box.
        driver.findElement(By.name("login")).click();  // Click on login

        // For the following task to wor, please make sure that you comment the login functionality.

        /*
           Task 2:
           Click on Forgot Password.
         */

        // driver.findElement(By.linkText("Forgot password?")).click();

        /*
           Task 3:
           click on forgot password using partial linkText locator.
         */

        //  driver.findElement(By.partialLinkText("Forgot")).click();

    }
}
