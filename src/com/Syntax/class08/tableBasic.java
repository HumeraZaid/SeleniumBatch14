package com.Syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class tableBasic {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        //  Go to the website
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

        /*
           Task: Print the whole table on the console.
         */

        WebElement allTable = driver.findElement(By.xpath("//table[@id='customers']"));
        String textAllTable = allTable.getText();

        System.out.println(textAllTable);

        // Print all the rows of the table
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        for(WebElement row : rows)
        {
            String rowText = row.getText();
            System.out.println(rowText);
            System.out.println("-----------------");
        }

        System.out.println("--------------------------------");

        /*
           Modified Task: Print all the rows which have the company Google.
         */
        List<WebElement> rows1 = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        for(WebElement row : rows1)
        {
            String rowText = row.getText();
            if(rowText.contains("Google"))
            {
                System.out.println(rowText);
            }
        }

        System.out.println("--------------------------------");

        /*
            Task: POrint all the individual columns of the table
         */

        List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td"));
        for(WebElement column:columns)
        {
            String columnText = column.getText();
            System.out.println(columnText);
            System.out.println("-----------------");
        }


    }
}
