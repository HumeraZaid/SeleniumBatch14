package com.Syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class windowHandlingAdvance {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to the SignUp page on google.com
        driver.get("http://accounts.google.com/signup");

        // Maximize the window
        driver.manage().window().maximize();

        // Click on the Help button
        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        helpBtn.click();

        // Click on the Privacy button
        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        privacyBtn.click();

        Set<String> allHandles = driver.getWindowHandles();

        // The title of our desired page is "Google Account Help" (we got this by going to the DOM and manually copying it from the title tag)

        // Get all the window handles
        for (String handle : allHandles)
        {
            // Switching the focus to the current handle of the set
            driver.switchTo().window(handle);

           // Get the title of the window to which the driver has switched
            String title = driver.getTitle();

           // Compare if the title is of the Help page
            if (title.equalsIgnoreCase("Google Account Help"))
            {
                System.out.println("the current page under focus is :" + title);
                break;
            }
        }

        // Fnd the Community button and click on it
        WebElement communityBtn = driver.findElement(By.xpath("//a[text()='Community']"));
        communityBtn.click();

    }
}
