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

public class Apparel {

    WebDriver driver;

    @Before
    public void setUP() {
        String baseUrl = "https://www.google.com/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @Test
    public void verifyUserSuccessfullyNavigatedToApparelPage() {
        driver.findElement(By.xpath("//div[text()='I agree']")).click();
        driver.findElement((By.xpath("//input[@class='gLFyf gsfi']"))).sendKeys("nopCommerce demo store");
        driver.findElement(By.xpath("//div[@class='lJ9FBc']//input[@value='Google Search']")).click();
        driver.findElement(By.xpath("//h3[text()='nopCommerce demo store']")).click();
        driver.findElement(By.xpath("//a[text()='Apparel ']")).click();

        String expectedMessage = "Apparel";
        WebElement message = driver.findElement(By.xpath("//div[@class='page-title']//h1"));
        String actualMessage = message.getText();
        Assert.assertEquals("User not on Apparel Page",
                expectedMessage,
                actualMessage);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

}