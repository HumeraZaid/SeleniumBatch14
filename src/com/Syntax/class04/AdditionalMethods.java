package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdditionalMethods {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the button web element
        WebElement btn = driver.findElement(By.cssSelector("button#buttoncheck"));

        // Get the text from the button web element
        String text = btn.getText();

        // Print it on console
        System.out.println(text);

        // Get the value of the "id" attribute from the button web element
        String idValue = btn.getAttribute("id");

        // Print it on console
        System.out.println(idValue);

    }
}
