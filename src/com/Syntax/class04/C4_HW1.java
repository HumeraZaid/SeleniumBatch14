package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C4_HW1 {

    /*
       Open Chrome browser and go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”:
       1. Enter valid username and password (username - Admin, password - Hum@nhrm123).
       2. Click on the LOGIN button.
       3. Then verify if the "Welcome Admin" message is there on the top-right corner.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input[id*='txtUsername']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("input[id*='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginButton = driver.findElement(By.cssSelector("input[id*='btnLogin']"));
        loginButton.click();

        WebElement message = driver.findElement(By.xpath("//a[text() = 'Welcome Admin']"));
        System.out.println("The message \"Welcome Admin\" is there on the top-right corner: " + message.isDisplayed());

    }
}
