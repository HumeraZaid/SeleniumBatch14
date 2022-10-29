package reviewClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Class03_HW1_SyntaxProjects_Review {

     /*
       Navigate to http://syntaxprojects.com/.
       Click on start practicing.
       Click on simple form demo.
       Enter any text on first text box.
       Click on show message.
       Quit the browser.
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe"); // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.

        WebDriver driver = new ChromeDriver();  // Create a WebDriver instance
        driver.get("http://syntaxprojects.com/");  // Go to syntaxprojects.com

        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[text()=' Start Practising ']")).click();
        Thread.sleep(3000);

        // Comment out either Method 1 or Method 2 , you cannot use them at the same time because they are clicking on the same button.

        // Method 1 -- Click on Simple Form Demo using indexing

        // driver.findElement(By.xpath("(//a[@class='list-group-item'])[1]")).click();

        // Method 2 -- Click on Simple Form Demo using and operator in the xpath

        driver.findElement(By.xpath("//a[@class='list-group-item' and @href='basic-first-form-demo.php']")).click();

    }
}
