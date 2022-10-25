package com.Syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        driver.navigate().to("https://www.facebook.com/");

        Thread.sleep(2000);

        for(int i=0; i<3; i++)
        {
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().forward();
            Thread.sleep(2000);
            driver.navigate().refresh();
        }

        driver.quit();
    }
}
