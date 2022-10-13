package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BmiTest {
    private WebDriver driver;

    @BeforeClass
    public void preconditions(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

    }

    @Test
    public void firstWeightIndexTest(){
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("100");
        driver.findElement(By.xpath("//select[@name='opt2']")).click();
        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String value = driver.findElement(By.xpath("//input[@name='si']")).getAttribute("value");
        Assert.assertEquals(value, "43.28");
    }

    @Test
    public void resultTextTest(){
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("100");
        driver.findElement(By.xpath("//select[@name='opt2']")).click();
        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String value = driver.findElement(By.xpath("//input[@name='desc']")).getAttribute("value");
        Assert.assertEquals(value, "Your category is Obese");
    }

    @Test
    public void usIndexWeightTest(){
        driver.findElement(By.xpath("//input[@name='wg']")).sendKeys("100");
        driver.findElement(By.xpath("//select[@name='opt2']")).click();
        driver.findElement(By.xpath("//option[@value='5']")).click();
        driver.findElement(By.xpath("//input[@name='cc']")).click();
        String value = driver.findElement(By.xpath("//input[@name='us']")).getAttribute("value");
        Assert.assertEquals(value, "44.01");
    }



    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }


}
