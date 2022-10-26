package com.Syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebOrder {

    /*
       Task 1:
       Go to smartbear.com.
       Enter username.
       Enter password.
       Click on login.
     */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");  // Go to smartbear.com

        driver.manage().window().maximize();  // Maximize the window

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester"); // Enter the username
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"); // Enter the password
        driver.findElement(By.className("button")).click();

        /*
           Task 2:
           Make sure that the title is correct, that is, Web Orders.
         */

        String title = driver.getTitle(); // Get the title of the page
        // System.out.println(title);

        if(title.equalsIgnoreCase("Web Orders"))
        {
            System.out.println("The title is correct: " + title);
        }
        else
        {
            System.out.println("The title is incorrect: " + title);
        }


    }
}
