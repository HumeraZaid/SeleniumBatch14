package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {
    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/basic-first-form-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Get the textbox web element
        // driver.findElement(By.cssSelector("input[placeholder*='Please enter']")).sendKeys("Abracadabra");

        // Another method to get the textbox web element
        WebElement textBox = driver.findElement(By.cssSelector("input[placeholder *= 'Please enter']"));
        textBox.sendKeys("Abracadabra");

        // Press the Show Message button
        WebElement button = driver.findElement(By.cssSelector("button[onclick ^= 'showIn']"));
        button.click();
    }
}
