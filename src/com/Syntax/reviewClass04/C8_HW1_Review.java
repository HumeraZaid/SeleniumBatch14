package com.Syntax.reviewClass04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class C8_HW1_Review {

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

        // Go to the website
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Maximize the window
        driver.manage().window().maximize();

        WebElement checkBox = driver.findElement(By.xpath(" //input[@type='checkbox']"));
        checkBox.click();

        // Click on the button
        WebElement button = driver.findElement(By.xpath("//button[text()='Remove']"));
        button.click();

        // Get the text
        WebElement text = driver.findElement(By.xpath("//p[text()= \"It's gone!\"]"));
        System.out.println(text.getText());

        // Click on the button
        WebElement buton2 = driver.findElement(By.xpath("//button[text()='Enable']"));
        buton2.click();

        // Define some explicit wait
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));

        // Send text
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abracadabra");
    }
}

