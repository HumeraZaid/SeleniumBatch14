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

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to smartbear.com
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        // Maximize the window
        driver.manage().window().maximize();

        // Enter the username
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");

        // Enter the password
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        // Click on login
        driver.findElement(By.className("button")).click();

        /*
           Task 2:
           Make sure that the title is correct, that is, Web Orders.
         */

        // Get the title of the page
        String title = driver.getTitle();
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
