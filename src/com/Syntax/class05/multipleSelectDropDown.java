package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class multipleSelectDropDown {

    public static void main(String[] args) throws InterruptedException {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/basic-select-dropdown-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        // Find the web element that contains the select tag
        WebElement DD = driver.findElement(By.xpath("//select[@id='multi-select']"));

        // Using the Select class
        Select sel = new Select(DD);

        // Select an option by index
        sel.selectByIndex(3);

        // Select an option by visible text
        sel.selectByVisibleText("Texas");

        // Introduce some sleep to observe the change from one option to another
        Thread.sleep(3000);

        // Deselect by index
        sel.deselectByIndex(3);

        // Write down the code to select all the options in the dropdown
        List<WebElement> options = sel.getOptions();

        for(int i=0; i<options.size(); i++)
        {
            sel.selectByIndex(i);
        }

        // Introduce some sleep to observe the change
        Thread.sleep(3000);

        // Deselect all the options in the dropdown
        sel.deselectAll();

        // How to check if the dropdown is multi-select or not using Selenium?
        boolean multiSelect = sel.isMultiple();
        System.out.println(multiSelect);

    }
}
