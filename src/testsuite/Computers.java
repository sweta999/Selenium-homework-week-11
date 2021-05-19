package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Computers {
    WebDriver driver;

    @Before
    public void setUP() {
        String baseUrl = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();  // creating object of ChromeDriver class. //driver is declared
        driver.manage().window().maximize();   //this is used to maximise the browser window
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //this will wait till browser is loaded
        driver.get(baseUrl);
    }

    @Test
    public void verifyUserSuccessfullyNavigatedToComputersPage() {
        WebElement iagree = driver.findElement(By.xpath("//div[text()='I agree']"));
        iagree.click();
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("https://demo.nopcommerce.com");
        driver.findElement(By.name("btnK")).submit();
        driver.findElement(By.xpath("//h3[@class='LC20lb DKV0Md']")).click();
        driver.findElement(By.xpath("//a[text()='Computers ']")).click();

        String expectedMessage = "Computers";
        WebElement message = driver.findElement(By.xpath("//h1")); //second path //h1[text()='Computers']
        String actualMessage = message.getText();
        Assert.assertEquals("User not on Computer Page", expectedMessage, actualMessage);

    }

    @After
    public void tearDown() {
        driver.quit();

    }

}

