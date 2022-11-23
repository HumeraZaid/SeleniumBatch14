package com.Syntax.reviewClass03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class C7_HW1_Review {

     /*
          Go to http://accounts.google.com/signup:
          1. Click on the Help and Privacy buttons.
          2. Click on the Community button.
          3. Go to the gmail.com page and enter your username in the form.

          Hint1:
          You can save the window handle in variables for later use.
         */

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to the Sign-in page on google.com
        driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S1677848054%3A1668130357093885&continue=https%3A%2F%2Faccounts.google.com%2F&followup=https%3A%2F%2Faccounts.google.com%2F&passive=1209600&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=ARgdvAswIGY5dQVAL_DC9sJchnLkBPPrWj5S72-X4t-nnF_jJGXUmwwPbCYoSNYp55bcn0_z_Kb2");

        // Maximize the window
        driver.manage().window().maximize();

        // Click on the Help button
        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        helpBtn.click();

        // Click on the Privacy button
        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        privacyBtn.click();

        String mainPageHandle = driver.getWindowHandle();

        Set<String> allHandles = driver.getWindowHandles();

        for(String handle:allHandles){
            driver.switchTo().window(handle);

            // Making sure that we have switched to the right page
            if(driver.getTitle().equalsIgnoreCase("Google Account Help")){

                break;
            }

        }
        System.out.println("The title of the current page is: " + driver.getTitle());
        System.out.println("I am here");
        Thread.sleep(2000);

        // Find the Community element and click on it
        WebElement communityBtn = driver.findElement(By.xpath("//a[text()='Community']"));
        communityBtn.click();

        driver.switchTo().window(mainPageHandle);
        System.out.println(driver.getTitle());

    }
}
