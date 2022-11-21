package com.Syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class C10_HW1 {

    /*
      Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login:
      1. Click on the Recruitment tab.
      2. Click on the Date of Application From calendar.
      3. Select any date, month, and year from the calendar.
     */

    public static void main(String[] args) throws IOException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Link to the properties file
        var path = "Data/config.properties";
        var fileInputStream = new FileInputStream(path);
        var properties = new Properties();
        properties.load(fileInputStream);

        // Read credentials from the properties file
        driver.get(properties.getProperty("URL"));
        var username = properties.getProperty("username");
        var password = properties.getProperty("password");

        // Enter the username
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);

        // Enter the password
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);

        // Click on the Login button
        driver.findElement(By.xpath("//input[@value='LOGIN']")).click();

        // Click on the Recruitment tab
        driver.findElement(By.xpath("//b[text()='Recruitment']")).click();

        // Click on the Date of Application Fromm calendar
        driver.findElement(By.id("candidateSearch_fromDate")).click();

        // Find the month dropdown by looking for the select tag
        WebElement months = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

        // Use the Select class
        Select month = new Select(months);

        // Select an option by index
        month.selectByIndex(7);

        // Find the year dropdown by looking for the select tag
        WebElement years = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));

        // Use the Select class
        Select year = new Select(years);

        // Select an option by value
        year.selectByValue("2018");

        // Get all the dates from the calendar
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[2]"));

        // Traverse through the list to find the desired date
        for(int i = 0; i < dates.size(); i++)
        {
            String date = dates.get(i).getText();
            if(date.equals("28"))
            {
                // Get the date on this row and click on it
                driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar']/tbody/tr[" + (i+1) + "]/td[2])")).click();
            }
        }
    }
}
