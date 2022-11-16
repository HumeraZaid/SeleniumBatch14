package com.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C3_HW1 {

    /*
       Navigate to http://syntaxprojects.com/:
       1. Click on Start Practicing.
       2. Click on Simple Form Demo.
       3. Enter any text on the first textbox.
       4. Click on Show Message.
       5. Quit the browser.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://syntaxprojects.com/");

        Thread.sleep(2000);

        driver.manage().window().maximize();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@id='btn_basic_example']")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[starts-with(@class,'list')]")).click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[contains(@placeholder, 'Message')]")).sendKeys("Keep calm and learn Selenium!!");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Show Message']")).click();

        Thread.sleep(3000);

       // driver.quit();

        driver.close();
    }
}
