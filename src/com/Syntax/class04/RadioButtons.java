package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtons {

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Go to syntaxprojects.com
        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");

        // Maximize the window
        driver.manage().window().maximize();

        //  Get the Male radio button
        WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));

        // Check if the radio button is displayed
        boolean displayStatus = maleRadioBtn.isDisplayed();

        // Print the display status
        System.out.println("The radio button is displayed: " + displayStatus);

        // Check whether the Male radio button is enabled
        boolean enableStatus = maleRadioBtn.isEnabled();

        // Print the enabled status
        System.out.println("The radio button is enabled: " + enableStatus);

        // Check whether the Male radio button is selected
        boolean selectStatus = maleRadioBtn.isSelected();

        // Print the select status
        System.out.println("The radio button is selected: " + selectStatus);

        // Check if the Male radio button is not selected, then click on it
        if(!selectStatus)
        {
            //  Perform a click operation on the Male radio button
            maleRadioBtn.click();
        }

        // Check the select status again
        selectStatus = maleRadioBtn.isSelected();
        System.out.println("The radio button is selected: " + selectStatus);
    }
}
