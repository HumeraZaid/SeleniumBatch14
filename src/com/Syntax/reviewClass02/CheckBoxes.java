package com.Syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to ironspider.com
        driver.get("https://www.ironspider.ca/forms/checkradio.htm");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the checkboxes
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='color']"));

        // What does this list contain? It contains all the 6 web elements

        for(WebElement checkBx : checkboxes)
        {

            // Find the desired checkbox
            String color = checkBx.getAttribute("value");

            if(color.equalsIgnoreCase("orange"))
            {
                // Click on the checkbox
                checkBx.click();
                break;
            }
        }

    }
}
