package com.Syntax.class06;

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

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/javascript-alert-box-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the "Click Me" button for the alert and click  on it
        WebElement simpleAlert = driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        simpleAlert.click();

        // Introduce some sleep to observe the change
        Thread. sleep(3000);

        // Handling the alert
        Alert simpleAlert1 = driver.switchTo().alert();
        simpleAlert1.accept();

        // Find the button for confirmation alert and click  on it
        WebElement confirmationAlert = driver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        confirmationAlert.click();

        // Introduce some sleep to observe the change
        Thread. sleep(3000);

        // Handling the alert
        Alert confirmationAlert1 = driver.switchTo().alert();
        confirmationAlert1.dismiss();

        // Find the prompt alert and send some text and accept it
        WebElement promptAlert = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        promptAlert.click();

        // Switch the focus to the alert
        Alert prompt1 = driver.switchTo().alert();

        // Introduce some sleep to observe the change
        Thread. sleep(3000);

        prompt1.sendKeys("abracadabra");
        prompt1.accept();
    }
}
