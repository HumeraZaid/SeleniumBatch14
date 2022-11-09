package reviewClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_HW2_Review {

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

        driver.findElement(By.xpath("//a[text()='Create new account']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Humera");
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Zaid");
        Thread.sleep(3000);
        // driver.findElement(By.xpath("//img[@src='https://static.xx.fbcdn.net/rsrc.php/v3/yZ/r/C6QZ-pcv3Bd.png']")).click();
        driver.findElement(By.xpath("//img[@class='_8idr img']")).click();
        Thread.sleep(3000);
        driver.close();
    }
}
