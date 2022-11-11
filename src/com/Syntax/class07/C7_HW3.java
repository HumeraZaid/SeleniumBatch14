package com.Syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C7_HW3 {


        /*
          Do not use thread.sleep or explicit wait for this HW.
          Go to https://syntaxprojects.com/dynamic-elements-loading.php:
          1. Click on the Start button.
          2. Get the "Welcome Syntax Technologies" text and print it on console.

          The text will be empty.
          Write down whatever the reason you understand of text being empty after exploring the DOM.
         */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/dynamic-elements-loading.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Part 1: Click on the Start button.
        WebElement startButton = driver.findElement(By.id("startButton")); // Find the Start button by ID
        startButton.click(); // Click on the Start button

        // Part 2: Get the "Welcome Syntax technologies" text and print it on console.
        WebElement welcomeText = driver.findElement(By.xpath("//h4[text()='Welcome Syntax Technologies']")); // Find the text by xpath
        String text = welcomeText.getText(); // Get the text
        System.out.println("The text is " + text); // Print the text

        // Reasons for the text being empty
        System.out.println("The text is empty because the DOM and the UI are not " +
                           "synchronized while retrieving the text. The WebDriver discovers the text on DOM before it shows " +
                           "on the UI.");
    }
}
