package com.Syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C6_HW1 {

    /*
       Go to https://chercher.tech/practice/frames:
       1. Check the checkbox.
       2. Select "Baby Cat" from the dropdown.
       3. Send text to the textbox as "DONE".
     */

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to chercher.com
        driver.get("https://chercher.tech/practice/frames");

        // Maximize the window
        driver.manage().window().maximize();

        // Part 1: Check the checkbox.
        driver.switchTo().frame("iamframe"); // Switch to the frame using name
        driver.switchTo().frame(0); // Switch to the frame using index
        WebElement checkBox = driver.findElement(By.id("a")); // Find the checkbox using the ID locator
        checkBox.click(); // Check the checkbox

        // Part 2:  Select "Baby Cat" from the dropdown.
        driver.switchTo().defaultContent(); // Switch the focus to the main page
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@data-ezsrc='dropdown-frame.html']"));
        driver.switchTo().frame(frame1); // Switch to the frame using WebElement
        WebElement dropDown = driver.findElement(By.id("animals")); // Find the dropdown using the ID locator
        Select select = new Select(dropDown); // Use the Select class
        select.selectByIndex(1); // Select an option by index

        // Part 3: Send text to the textbox as "DONE".
        driver.switchTo().defaultContent(); // Switch the focus to the main page
        driver.switchTo().frame(0); // Switch to the frame using index
        WebElement textBox = driver.findElement(By.xpath("//input")); // Find the textbox using xpath
        textBox.sendKeys("DONE"); // Send keys to the textbox

        // Thread.sleep(3000); // Introduce sleep to observe the changes

        // driver.quit(); // Quit the browser
    }

}
