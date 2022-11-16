package com.Syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class C8_HW1 {

    /*
       Go to https://the-internet.herokuapp.com/dynamic_controls.
       1. Click on A checkbox and then click on Remove.
       2. Verify the text.
       3. Click on Enable and verify the textbox is enabled.
       4. Enter text and click on Disable.
       5. Verify the textbox is disabled.
     */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        //  Go to the website
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Part 1: Click on A checkbox and then click on Remove.
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']")); // Find A checkbox by xpath
        checkBox.click(); // Click on A checkbox

        WebElement removeButton = driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")); // Find the Remove button by xpath
        removeButton.click(); // Click on Remove


        // Part 2: Verify the text.
        WebDriverWait goneWait = new WebDriverWait(driver, 20); // Define some explicit wait
        goneWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))); // Find the "It's gone!" message by xpath and wait for it to appear

        WebElement goneMessage = driver.findElement(By.xpath("//p[@id='message']")); // Find the "It's gone!" message by xpath
        String goneText = goneMessage.getText(); // Get text from the "It's gone!" message
        System.out.println("Text displayed when the button is removed: " + goneText); // Print the text


        // Part 3: Click on Enable and verify the textbox is enabled.
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']")); // Find the Enable button by xpath
        enableButton.click(); // Click on Enable

        WebDriverWait enableWait = new WebDriverWait(driver, 20); // Define some explicit wait
        enableWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))); // Find the "It's enabled!" message by xpath and wait for it to appear

        WebElement enabledMessage = driver.findElement(By.xpath("//p[@id='message']")); // Find the "It's enabled!" message by xpath
        String enabledText = enabledMessage.getText(); // Get text from the "It's enabled!" message
        System.out.println("Text displayed when the button is enabled: " + enabledText); // Print the text


        // Part 4: Enter text and click on Disable.
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']")); // Find the textbox by xpath
        textBox.sendKeys("Keep calm and learn Selenium!!"); // Send keys to the textbox

        WebElement disableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']")); // Find the Disable button by xpath
        disableButton.click(); // Click on Disable


        // Part 5: Verify the textbox is disabled.
        WebDriverWait disableWait = new WebDriverWait(driver, 20); // Define some explicit wait
        disableWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']"))); // Find the "It's disabled!" message by xpath and wait for it to appear

        WebElement disabledMessage = driver.findElement(By.xpath("//p[@id='message']")); // Find the "It's disabled!" message by xpath
        String disabledText = disabledMessage.getText(); // Get text from the "It's disabled!" message
        System.out.println("Text displayed when the button is disabled: " + disabledText); // Print the text
    }
}
