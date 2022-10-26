package com.Syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW1_ParaBank {

    /*
        Navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
        Fill out the form.
        Click on register.
        Close the browser.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");

        driver.manage().window().maximize();

        driver.findElement(By.id("customer.firstName")).sendKeys("Humera");
        driver.findElement(By.name("customer.lastName")).sendKeys("Zaid");
        driver.findElement(By.id("customer.address.street")).sendKeys("1234 N Maplewood Ave");
        driver.findElement(By.name("customer.address.city")).sendKeys("Chicago");
        driver.findElement(By.id("customer.address.state")).sendKeys("Illinois");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("60659");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("123-456-7890");
        driver.findElement(By.name("customer.ssn")).sendKeys("123-45-6789");
        driver.findElement(By.id("customer.username")).sendKeys("humerazaid");
        driver.findElement(By.name("customer.password")).sendKeys("zaidhumera");
        driver.findElement(By.id("repeatedPassword")).sendKeys("zaidhumera");
        driver.findElement(By.className("button")).click();

        Thread.sleep(10000);

        driver.quit();
    }
}
