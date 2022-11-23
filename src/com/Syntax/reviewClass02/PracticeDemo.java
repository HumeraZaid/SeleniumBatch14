package com.Syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeDemo {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        // Maximize the window
        driver.manage().window().maximize();

        // When user sends in the username Admin
        WebElement userName = driver.findElement(By.id("txtUsername"));

        // Send the username
        userName.sendKeys("Admin");

        // Then user sends in the wrong password
        WebElement pass = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        pass.sendKeys("abracadabra");

        // Then user clicks on the login button
        WebElement btn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        btn.click();

        /*
           Task:
           Then VERIFY THAT THE "Invalid credentials" ERROR is there.
         */

        // Get the error message from the DOM
        WebElement errorMSG = driver.findElement(By.xpath("//span[@id='spanMessage']"));
        String error = errorMSG.getText();

        // Verification

        if(error.equalsIgnoreCase("Invalid credentials"))
        {
            System.out.println("The correct error message is there ---> verified");
        }
        else
        {
            System.out.println("The correct error message is not there ---> no verified");
        }
    }
}
