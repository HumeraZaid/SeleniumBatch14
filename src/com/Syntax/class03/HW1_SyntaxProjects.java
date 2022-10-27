package com.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1_SyntaxProjects {

    /*
       Navigate to http://syntaxprojects.com/.
       Click on start practicing.
       Click on simple form demo.
       Enter any text on first text box.
       Click on show message.
       Quit the browser.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("http://syntaxprojects.com/");  // Go to syntaxprojects.com

        Thread.sleep(2000);

        driver.manage().window().maximize();  // Maximize the window

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id='btn_basic_example']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[starts-with(@class,'list')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[contains(@placeholder, 'Message')]")).sendKeys("Keep calm and learn Selenium!!");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Show Message']")).click();

        Thread.sleep(3000);

        driver.quit();
    }
}
