package com.Syntax.reviewClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C7_HW2_Review {

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

        // Find the Get New User button
        driver.findElement(By.xpath("//button[text()='Get New User']")).click();

        // Find the web element
        WebElement img = driver.findElement(By.xpath("//p[contains(text(),'First Name')]"));
        System.out.println(img.getText());
    }
}
