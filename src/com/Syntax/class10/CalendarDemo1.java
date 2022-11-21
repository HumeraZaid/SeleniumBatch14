package com.Syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarDemo1 {

    public static void main(String[] args) {


        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Go to the website
        driver.get("https://www.delta.com/");

        // Click on the calendar
        WebElement calendar=driver.findElement(By.xpath("//span[text()='Depart']"));
        calendar.click();

        // Get the month and check if it is the desired month
        WebElement month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']"));

        boolean isFound = false;
        while(!isFound)
        {
            String monthName = month.getText();

             if(monthName.equalsIgnoreCase("March"))
             {
                 // Get all the dates from the table
                 List<WebElement> dates = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]/tbody/tr/td"));
                 // Traverse through the list to find your desired date
                 for(WebElement date : dates)
                 {
                 String currentDate = date.getText();
                 if(currentDate.equalsIgnoreCase("15")){
                    date.click();
                    break;
                }
            }
            System.out.println("I have found the desired month: " + monthName);
            isFound = true;
        }
        else
        {
            WebElement nxtBtn = driver.findElement(By.xpath("//span[text()='Next']"));
            nxtBtn.click();
        }
      }
    }

}
