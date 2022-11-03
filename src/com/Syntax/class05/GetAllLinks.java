package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GetAllLinks {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to ebay.com
        driver.get("https://www.ebay.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Get all the links, that is, anchor tags from the website
        List<WebElement> ebayLinks = driver.findElements(By.tagName("a"));

        // Print the size of the "ebayLinks" list
        System.out.println("The size of the list is: " + ebayLinks.size());

        // Implementing a for loop to traverse through the list of web elements
        for(WebElement ebayLink : ebayLinks)
        {

            // Extracting the value of attribute href because it contains the link embedded in the web elmenent
            String link = ebayLink.getAttribute("href");

            // Print the link
            System.out.println(link);
        }










    }
}
