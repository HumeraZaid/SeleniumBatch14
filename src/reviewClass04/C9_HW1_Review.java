package reviewClass04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C9_HW1_Review {

     /*
        Go to http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login:
        1. Click on PIM.
        2. Click on Employee List.
        3. From the table, choose one id (it must be from the first page)
           and check the checkBox for that id (your logic should be dynamic, should work for any ID number).

           The username is admin and the password is Hum@nhrm123.
     */

    public static void main(String[] args) {

        // Set the path to the driver to link it with our class. On MAC, you don't need .exe. On Windows, you need .exe.
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        // Create a WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Introduce some implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Maximize the window
        driver.manage().window().maximize();

        // Go to the website
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        // Code to get to the table page
        WebElement username = driver.findElement(By.xpath("//input[ @type ='text']"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[ @type ='password']"));
        password.sendKeys("Hum@nhrm123");

        WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
        button.click();

        WebElement pimButton = driver.findElement(By.xpath("//b[text()='PIM']"));
        pimButton.click();

        WebElement employeeList = driver.findElement(By.xpath("//a[text()='Employee List']"));
        employeeList.click();

        // Get a particular ID 44969A and check the checkbox
        List<WebElement> listOfID = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));

        // Traverse
        for (int i=0; i<listOfID.size(); i++)
        {
            String id = listOfID.get(i).getText();
            if(id.equalsIgnoreCase("44969A"))
            {
                System.out.println(i);
                // Check the checkbox
                WebElement checkbox = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (i+1) + "]/td[1]"));
                checkbox.click();
                break;
            }
        }
    }
}
