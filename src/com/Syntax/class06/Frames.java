package com.Syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to chercher.com
        driver.get("https://chercher.tech/practice/frames");

        // Maximize the window
        driver.manage().window().maximize();

        /*
           Task: Print "Animals" on console
         */

        // Switch to the frame using index
        driver.switchTo().frame(1);

        // Find the "Animals" text and print it on the console
        WebElement animalText = driver.findElement(By.xpath("//b[text()='Animals :']"));
        String text = animalText.getText();
        System.out.println(text);

        /*
           Task: Check the checkbox
         */

        // Switch the focus to the main page
        driver.switchTo().defaultContent();

        // Switch to the frame (using name) that contains the subframe with the checkbox
        driver.switchTo().frame("frame1");

        // Send keys to the textbox
        WebElement inputTxt = driver.findElement(By.xpath("//input"));
        inputTxt.sendKeys("abracadbra");

        // Find the frame through xpath and switch to it using WebElement
        WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
        driver.switchTo().frame(frame3);

        // Find the checkbox
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='a']"));
        checkBox.click();
    }

}
