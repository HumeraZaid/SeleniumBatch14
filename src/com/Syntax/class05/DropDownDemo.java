package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDemo {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/basic-select-dropdown-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the dropdown web element by looking for the select tag
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='select-demo']"));

        // Use the Select class
        Select select = new Select(dropDown);

        // Select an option by index
        select.selectByIndex(5);

        // Introduce some sleep to observe the change from one option to another
        Thread.sleep(3000);

        // Select an option by visible text
        select.selectByVisibleText("Saturday");

        // Introduce some sleep to observe the change from one option to another
        Thread.sleep(3000);

        // Select an option by value
        select.selectByValue("Sunday");

        // Get all the options available in the dropdown
        List<WebElement> options = select.getOptions();

        // Traverse through the options
        for(int i=0; i<options.size(); i++)
        {
            WebElement option = options.get(i);
            String text = option.getText();
            System.out.println(text);

            if(text.equalsIgnoreCase("Friday"))
            {
                select.selectByIndex(i);
            }
        }
    }
}
