package com.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathDemo {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to fb.com
        driver.get("https://www.facebook.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Enter the username
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Abracadabra");

        // Click on Forgot Password?
        driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();

        // Click on Log In
        // driver.findElement(By.xpath("//button[contains(@type,'sub')]")).click();

        // Click on Forgot Password?
        // driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click();
    }
}
