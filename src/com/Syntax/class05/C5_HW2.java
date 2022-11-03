package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C5_HW2 {

    /*
      1. Go to ebay.com.
      2. Get all the categories and print them in the console (in search bar you will see categories mentioned as dropdown).
      3. Select Computers/Tables & Networking.
      4. Click on Search.
      5. Verify the title.
     */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        driver.manage().window().maximize();

        WebElement allCategories = driver.findElement(By.xpath("//select[@name='_sacat']"));

        Select categories = new Select(allCategories);

        List<WebElement> options = categories.getOptions();

        for(int i=0; i<options.size(); i++)
        {
            WebElement option = options.get(i);
            String text = option.getText();
            System.out.println(text);
        }

        categories.selectByValue("58058");

        WebElement search = driver.findElement(By.id("gh-btn"));
        search.click();

        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        String newTitle = title;

        if(title.equalsIgnoreCase(newTitle))
        {
            System.out.println("The title " + "\"" + newTitle + "\"" + " is verified.");
        }
        else
        {
            System.out.println("The title " + "\"" + newTitle + "\"" + " is not verified.");
        }
    }
}
