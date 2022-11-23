package com.Syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the radio buttons
        List<WebElement> radioBtns = driver.findElements(By.xpath("//input[@name = 'ageGroup']"));

        // Traverse through the list of web elements
        for(WebElement radioBtn : radioBtns)
        {

            // Find the desired radio button
            String option = radioBtn.getAttribute("value");

            if(option.equalsIgnoreCase("5 - 15"))
            {
                // Click on the radio button
                radioBtn.click();
            }
        }
    }
}
