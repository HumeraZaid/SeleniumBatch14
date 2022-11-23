package com.Syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDown {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to fb.com
        driver.get("https://www.facebook.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the "Create new account" button and click on it
        WebElement createAccountBtn = driver.findElement(By.xpath("//a[text() = 'Create new account']"));
        createAccountBtn.click();

        // Introduce some sleep for the window to open up
        Thread.sleep(3000);

        // Select the date from the dropdown
        /* Approach to use the select
           1. Find the web element that contains the select tag
           2. Use the Select class - Select sel =new Select(web element)
         */

        // 1. Find the web element that contains the select tag
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));

        // 2. Use the Select class to initiate an instance
        Select selectDay = new Select(day);

        // We now have three methods

        // 1. Select by index
        selectDay.selectByIndex(4);
        Thread.sleep(2000);

        // 2. Select by visible text
        selectDay.selectByVisibleText("31");
        Thread.sleep(2000);

        // 3. Select by value
        selectDay.selectByValue("16");

        // 1. Find the web element that contains the select tag
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));

        // 2. Use the Select class to initiate an instance
        Select selectMonth = new Select(month);

        // Select by visible text
        selectMonth.selectByVisibleText("Aug");

        /*
          Task:
          Print all the available months in the console
         */

        // Get all the available options in the dropdown
        List<WebElement> Options = selectMonth.getOptions();

        // Traverse through the loop and print each web element
        for(int i=0; i<Options.size(); i++)
        {
            String months = Options.get(i).getText();
            System.out.println(months);
        }

    }
}
