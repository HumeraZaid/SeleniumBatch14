package com.Syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class C9_HW1 {

    /*
        Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login:
        1. Click on PIM.
        2. Click on Employee List.
        3. From the table, choose one id (it must be from the first page)
           and check the checkBox for that id (your logic should be dynamic, should work for any ID number).

           The username is admin and the password is Hum@nhrm123.
     */

    public static void main(String[] args) throws IOException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Part 1: 1. Click on PIM.
        var path = "Data/C9_HW1.properties";
        var fileInputStream = new FileInputStream(path);
        var properties = new Properties();
        properties.load(fileInputStream);

        driver.get(properties.getProperty("URL"));

        driver.manage().window().maximize(); // Maximize the window

        var username = properties.getProperty("username");
        var password = properties.getProperty("password");

        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username); // Enter the username

        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password); // Enter the password

        driver.findElement(By.xpath("//input[@value='LOGIN']")).click(); // Click on the Login button

        driver.findElement(By.xpath("//b[text()='PIM']")).click(); // Click on PIM


        // Part 2: Click on Employee List.
        driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']")).click(); // Click on Employee List


        // Part 3: From the table, choose one ID (it must be from the first page) and check the checkbox for that ID (your logic should be dynamic, should work for any ID number).
        List<WebElement> secondColumn = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));

        for(int i = 0; i < secondColumn.size(); i++)
        {
            String columnText = secondColumn.get(i).getText();
            // System.out.println(columnText);
            if(columnText.equals("34438833"))
            {
                WebElement checkBox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+ (i+1) +"]/td[1]"));
                checkBox.click();
            }
        }
    }


}
