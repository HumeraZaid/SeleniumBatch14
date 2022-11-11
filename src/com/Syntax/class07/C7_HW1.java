package com.Syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class C7_HW1 {

        /*
          Go to http://accounts.google.com/signup:
          1. Click on the Help and Privacy buttons.
          2. Click on the Community button.
          3. Go to the gmail.com page and enter your username in the form.

          Hint1:
          You can save the window handle in variables for later use.
         */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to the SignUp page on google.com
        driver.get("http://accounts.google.com/signup");

        // Maximize the window
        driver.manage().window().maximize();

        // Store the window handle title in a variable
        String gMailMainPage = driver.getWindowHandle();

        // Part1: Click on the Help and Privacy buttons.
        WebElement helpButton = driver.findElement(By.xpath("//a[@target='_blank' and " +
                "@href='https://support.google.com/accounts?hl=en&p=account_iph']")); // Find the Help button using xpath
        helpButton.click(); // Click on the Help button
        WebElement privacyButton = driver.findElement(By.xpath("//a[@target='_blank' " +
                "and @href='https://accounts.google.com/TOS?loc=US&hl=en&privacy=true']")); // Find the Privacy button using xpath
        privacyButton.click(); // Click on the Privacy button


        // Part 2: Click on the Community button.
        Set<String> windowHandles = driver.getWindowHandles(); // Get all the window handles in a set
        for(String windowHandle : windowHandles) // Traverse through all the handles of the set
        {
            driver.switchTo().window(windowHandle); // Switch the focus to the current handle of the set
            String title = driver.getTitle(); // Get the title of the window to which the driver has switched
            if (title.equalsIgnoreCase("Google Account Help")) // Compare if the title is of the Help page
            {
                break;
            }
        }
        WebElement communityButton = driver.findElement(By.xpath("//a[@aria-current='false' and " +
                "@href='/accounts/community?hl=en']")); // Find the Community button
        communityButton.click(); // Click on the Community button


        // Part 3: Go to the gmail.com page and enter your username in the form.
        driver.switchTo().window(gMailMainPage); // Switch focus to the gmail.com page
        WebElement username = driver.findElement(By.id("username")); // Find the Username field using ID
        username.sendKeys("HumeraZaid"); // Send keys to the Username field

    }


}
