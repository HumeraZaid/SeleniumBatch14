package com.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpathDemo {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("https://www.facebook.com/");  // Go to fb.com

        driver.manage().window().maximize();  // Maximize the window

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Abracadabra"); // Enter the username
        driver.findElement(By.xpath("//a[text()='Forgot password?']")).click(); //  Click on Forgot Password?
       // driver.findElement(By.xpath("//button[contains(@type,'sub')]")).click(); //  Click on Log In
       // driver.findElement(By.xpath("//a[contains(text(),'Forgot')]")).click(); //  Click on Forgot Password?
    }
}
