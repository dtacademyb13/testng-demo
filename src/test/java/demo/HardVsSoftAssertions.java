package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HardVsSoftAssertions {


    WebDriver driver;



    @Test
    public void testValidLogin(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

       // Hard Assertions
//        Assert.assertEquals(driver.getTitle(), "Web Orderz");
//        Assert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
//        Assert.assertTrue(driver.getPageSource().contains("Welcome"));

        // Soft Assertions

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(), "Web Orderz");
        softAssert.assertEquals(driver.getCurrentUrl(), "http://secure.smartbearsoftware.com/samples/testcomplete12/weborderz/");
        softAssert.assertTrue(driver.getPageSource().contains("Welcome"));

        driver.quit();

        softAssert.assertAll();

    }









}
