package com.Syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C7_HW2 {

    /*
       Go to https://syntaxprojects.com/dynamic-data-loading-demo.php:
       1. Click on Get New User.
       2. Get the firstname of user and print it on console.
     */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/dynamic-data-loading-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Part 1: Click on Get New User.
        WebElement getNewUser = driver.findElement(By.id("save")); // Find the Get New User button by ID
        getNewUser.click(); // Click on the Get New User button


        // Part 2: Get the firstname of user and print it on console.
        WebElement firstName = driver.findElement(By.xpath("//p[contains(text()" +
                ",'First Name')]")); // Find the First Name field by xpath
        String text = firstName.getText(); // Get text from the First Name field
        System.out.println(text); // Print the text on console
    }
}
