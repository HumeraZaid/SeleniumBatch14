package reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class C5_HW2_Review {

    /*
      Go to ebay.com:
      1. Get all the categories and print them in the console (in the Search bar, you will see categories mentioned in a dropdown).
      2. Select Computers/Tables & Networking.
      3. Click on Search.
      4. Verify the title.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        driver.manage().window().maximize();

        // Select from the dropdown
        WebElement dropDwn = driver.findElement(By.xpath("//select[@id='gh-cat']"));

        Select sel= new Select(dropDwn);

        sel.selectByValue("58058");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Verify the title
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//title")).getText());
        String title = driver.getTitle();

        if(title.equalsIgnoreCase("Computers, Laptops, Tablets & Network Hardware for Sale - eBay"))
        {
            System.out.println("The title is verified");
        }
        else
        {
            System.out.println("The title is incorrect");
        }

    }

}
