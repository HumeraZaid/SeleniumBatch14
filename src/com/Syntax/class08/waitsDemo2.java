package com.Syntax.class08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class waitsDemo2 {

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
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        // Click on the button that pops up the alert
        WebElement button1 = driver.findElement(By.xpath("//button[@id='alert']"));
        button1.click();

        // Because we don't have a web element associated with the alert in the DOM, so there is no purpose of using implicit wait (which waits for the web element to be found). So, we use explicit wait in this scenario.
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.alertIsPresent());

        // Handle the alert
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
    }

}
