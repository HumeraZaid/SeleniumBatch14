package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxDemo {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("http://syntaxprojects.com/basic-checkbox-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the checkbox
        WebElement checkBox = driver.findElement(By.id("isAgeSelected"));

        // Click on the checkbox
        checkBox.click();

    }
}
