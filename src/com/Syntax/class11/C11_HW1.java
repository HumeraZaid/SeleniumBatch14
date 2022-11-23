package com.Syntax.class11;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class C11_HW1 {

   /*
     Go to https://demo.guru99.com/test/simple_context_menu.html:
     1. Right-click on the button, select edit and handle the alert.
     2. Double-click on the button and handle the alert
   */

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Go to the website
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        // Part 1: 1. Right-click on the button, select edit and handle the alert.
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']")); // Find the right-click button by xpath
        Actions action = new Actions(driver); // Action class
        action.contextClick(rightClick).perform(); // Perform the right-click action
        WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']")); // Find the Edit option by xpath
        edit.click(); // Click on the Edit option
        Alert alert = driver.switchTo().alert(); // Switch the driver focus to the alert
        Thread.sleep(2000); // Introduce some sleep to observe the change
        alert.accept(); // Handle the alert


        // Part 2: Double-click on the button and handle the alert
        WebElement doubleClick = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']")); // Find the double-click button by xpath
        action.doubleClick(doubleClick).perform(); // Perform the double-click action
        driver.switchTo().alert(); // Switch the driver focus to the alert
        Thread.sleep(2000); // Introduce some sleep to observe the change
        alert.accept(); // Handle the alert
    }
}
