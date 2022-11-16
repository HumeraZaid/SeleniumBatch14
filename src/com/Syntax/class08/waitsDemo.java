package com.Syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class waitsDemo {

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

        // Click on the "Change Text to Selenium Webdriver" button
        WebElement button1 = driver.findElement(By.xpath("//button[@id='populate-text']"));
        button1.click();

        // Get the "Selenium Webdriver" text
        WebElement webDriverText = driver.findElement(By.xpath("//h2[text()='Selenium Webdriver']"));

        // Print out text on the screen
        System.out.println(webDriverText.getText());

        // Task 2
        // Click on the "Display button after 10 seconds" button
        WebElement button2 = driver.findElement(By.xpath("//button[@id='display-other-button']"));
        button2.click();

        // As the button appears up after some time, so in order to click it or get text from it, we need to define some explicit wait

        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='hidden']")));

        WebElement visibleBtn = driver.findElement(By.xpath("//button[@id='hidden']"));
        visibleBtn.click();
    }
}
