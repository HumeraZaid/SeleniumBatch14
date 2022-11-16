package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C5_HW1 {

    /*
      Go to fb.com:
      1. Click on Create new account.
      2. Fill out the whole form.
      3. Take a screenshot of filled out form manually and share in HW channel along with code.
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

        WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        Select month = new Select(birthMonth);

        month.selectByIndex(6);

        WebElement birthDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        Select day = new Select(birthDay);

        day.selectByVisibleText("10");

        WebElement birthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        Select year = new Select(birthYear);

        year.selectByValue("1991");

        WebElement femaleRadioBtn = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        femaleRadioBtn.click();

        WebElement signUpBtn = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUpBtn.click();

    }
}
