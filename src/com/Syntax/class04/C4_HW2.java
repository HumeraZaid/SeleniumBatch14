package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C4_HW2 {

    /*
       HRMS Application Negative Login:
       Open Chrome browser and go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”:
       1. Enter valid username.
       2. Leave password field empty.
       3. Click on the LOGIN button.
       4. Verify if error message with text “Password cannot be empty” is displayed.

       Hint:
       You can use if else condition for verification of message.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input[id*='txtUsername']"));
        username.sendKeys("Admin");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id*='btnLogin']"));
        loginButton.click();

        WebElement spanMessage = driver.findElement(By.xpath("//span[text()='Password cannot be empty']"));
        String message = spanMessage.getText();
        boolean displayStatus = spanMessage.isDisplayed();

        if(displayStatus)
        {
            System.out.println("\"" + message + "\"" + " is displayed: " + displayStatus);
        }
        else
        {
            System.out.println("\"" + message + "\"" + " is displayed: " + displayStatus);
        }
    }
}
