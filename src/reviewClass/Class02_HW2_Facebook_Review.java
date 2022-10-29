package reviewClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class02_HW2_Facebook_Review {

     /*
      Navigate to fb.com.
      Click on create new account.
      Fill up all the text boxes.
      Close the popup.
      Close the browser.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("https://www.facebook.com/");  // Go to fb.com

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()='Create new account']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Humera");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Zaid");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[contains(@src,'https://static.xx.fbcdn.net/rsrc.php/v3/yZ/r/C6QZ-pcv3Bd')]")).click();
        Thread.sleep(3000);
        driver.close();
    }
}
