package com.Syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class calendarPagination {

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
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        // Code to get to the table page
        WebElement username = driver.findElement(By.xpath("//input[ @type ='text']"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[ @type ='password']"));
        password.sendKeys("Hum@nhrm123");

        WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
        button.click();

        WebElement pimButton = driver.findElement(By.xpath("//b[text()='PIM']"));
        pimButton.click();

        // Find and click on the Employee List tab
        WebElement employeeListBtn = driver.findElement(By.xpath("//a[text()='Employee List']"));
        employeeListBtn.click();

        boolean idFound = false;
        while(!idFound)
        {
            // Get all the IDs from the columns
            List<WebElement> columnID = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
            for (int i = 0; i < columnID.size(); i++) {

            // Extract the ID from the entry in list
                String id = columnID.get(i).getText();
            // Check if it is the desired ID
                if (id.equalsIgnoreCase("40907A")) {
            // Check the checkbox associated with this particular row
                    System.out.println("I have found the ID on row number " + (i + 1));
                    WebElement checkBox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (i + 1) + "]/td[1]"));
                    checkBox.click();
                    idFound = true;
                    break;
                }

            }
            if (!idFound){
                WebElement nextButton = driver.findElement(By.xpath("//a[text()='Next']"));
                nextButton.click();
            }
        }

    }
}
