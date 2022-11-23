package com.Syntax.reviewClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C6_HW1_Review {

    /*
       Go to https://chercher.tech/practice/frames:
       1. Check the checkbox.
       2. Select "Baby Cat" from the dropdown.
       3. Send text to the textbox as "DONE".
     */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to chercher.com
        driver.get("https://chercher.tech/practice/frames");

        // Maximize the window
        driver.manage().window().maximize();

        // Switch the focus of the driver to the parent iframe whose ID is "iframe1"
        driver.switchTo().frame("frame1");

        // Switch the focus to the child frame
        driver.switchTo().frame(0);

        // Find the checkbox
        WebElement checkBox = driver.findElement(By.id("a"));
        checkBox.click();

        // Switch the focus back to home content
        driver.switchTo().defaultContent();

        // Switching to the frame which has the dropdown
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='frame2']"));
        driver.switchTo().frame(frame);

        // Find the Select tag
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='animals']"));

        // Use the Select class
        Select sel= new Select(dropDown);

        // Select an option by index
        sel.selectByIndex(1);

        // Switch the focus to the main page
        driver.switchTo().defaultContent();

        // Switch to the frame which has the textbox
        driver.switchTo().frame("frame1");

        // Find the textbox
        driver.findElement(By.xpath("//input")).sendKeys("abracdabra");

    }
}
