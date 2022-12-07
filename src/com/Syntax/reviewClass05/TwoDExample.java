package com.Syntax.reviewClass05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TwoDExample {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Driverss/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Go to the website
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        // Fill out username
        driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("admin");

        // Fill out password
        driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("Hum@nhrm123");

        // Click on the Login button
        driver.findElement(By.xpath("//input[@name='Submit']")).click();

        // Find the PIM button
        WebElement pimBtn = driver.findElement(By.xpath("//b[text()='PIM']"));

        // Click on it
        pimBtn.click();

        // Find the Employee List tab
        WebElement employeeListBtn = driver.findElement(By.xpath("//a[text()='Employee List']"));

        // Click on it
        employeeListBtn.click();

        // Go to the table look for the ID 45156A and check the checkbox associated with it

        // Counter variable
        int rowCount = 0;
        boolean notfound = true;
        int idNumber = 1;

        //  A while loop continues to execute till the condition in the parenthesis is TRUE
        while (notfound) {

            // Get all the data in the column ID of the table
            List<WebElement> idColumn = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));

            for (WebElement id : idColumn) {
                String personID = id.getText();

                if (personID.equals("41641A") || personID.equals("4840054")) {
                    // System.out.println("Hey, I have successfully found the ID");  // Check if our code is right
                    System.out.println("The row number of the desired ID is " + (rowCount + 1));
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (rowCount + 1) + "]/td[1]"));
                    checkBox.click();
                    // idNumber = 1 -> 1==2 -not true - will run again - idNumber = 2 -> 2==2
                    if (idNumber == 2) {
                        notfound = false;  // When we find the second condition, we want to put false
                    }
                    idNumber = idNumber + 1;
                    break;
                }
                rowCount = rowCount + 1;
            }
            if (notfound) {
                WebElement nextBtn = driver.findElement(By.xpath("//a[text()='Next']"));
                nextBtn.click();
                rowCount = 0;  // We need to reset the count

            }
        }
    }
}
