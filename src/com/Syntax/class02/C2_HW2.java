package com.Syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class
C2_HW2 {

    /*
      Navigate to fb.com.
      Click on create new account.
      Fill up all the text boxes.
      Close the popup.
      Close the browser.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();

        driver.findElement(By.linkText("Create new account")).click();

        Thread.sleep(3000);

        driver.findElement(By.name("firstname")).sendKeys("Humera");
        driver.findElement(By.name("lastname")).sendKeys("Zaid");
        driver.findElement(By.name("reg_email__")).sendKeys("humerazshelia@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("humerazshelia@gmail.com");
        driver.findElement(By.id("password_step_input")).sendKeys("zaidhumera");

        Thread.sleep(3000);

        driver.findElement(By.xpath("//img[@class='_8idr img']")).click();

        Thread.sleep(3000);

        // driver.quit();

        driver.close();
    }
}

