package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxDemo2 {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("http://syntaxprojects.com/basic-checkbox-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));

        // Travers through the  list of checkboxes to find the desired one
        for(WebElement checkBox : checkBoxes)
         {
             // Get the attribute value to check if this is the right option to select
             String optionName = checkBox.getAttribute("value");

             // Using an if condition to make sure it is the right checkbox
             if(optionName.equalsIgnoreCase("Option-3")){

             // If passed, click on it
             checkBox.click();
        }
      }
    }
}
