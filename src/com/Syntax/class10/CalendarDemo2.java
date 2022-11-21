package com.Syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarDemo2 {

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
        WebElement calendar = driver.findElement(By.xpath("//span[text()='Depart']"));
        calendar.click();

        // Get the month
        WebElement month = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']"));
        WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));

        boolean isFound = false;
        while (!isFound)
        {
            String monthText = month.getText();
            if (monthText.equalsIgnoreCase("March"))
            {
                List<WebElement> Dates = driver.findElements(By.xpath("(//table[@class='dl-datepicker-calendar'])[1]/tbody/tr/td"));
                for(WebElement date:Dates)
                {
                    String currentDate = date.getText();
                    if(currentDate.equalsIgnoreCase("20")){
                        date.click();
                        break;
                    }

                }
                isFound = true;
            }
            else
            {
                nextBtn.click();
            }
        }

    }
}
