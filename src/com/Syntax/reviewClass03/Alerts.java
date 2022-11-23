package com.Syntax.reviewClass03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to demoqa.com
        driver.get("https://demoqa.com/alerts");

        // Maximize the window
        driver.manage().window().maximize();

        // Click on the button
        WebElement alertBtn1 = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertBtn1.click();

        // Introduce some sleep to observe the change
        Thread.sleep(2000);

        // Use the Alert interface
        Alert Alert1 = driver.switchTo().alert();
        Alert1.accept();

        // Alert button 3
        WebElement alertBtn3 = driver.findElement(By.xpath("//button[@id='promtButton']"));
        alertBtn3.click();

       // Reusing the already declared alert
        Alert1.sendKeys("abracadbra");
        Alert1.accept();
   }
}
