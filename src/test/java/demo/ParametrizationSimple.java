package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ParametrizationSimple {



    WebDriver driver;
    @Test
    @Parameters ({"usr", "pass"})
    public void testValidLogin(String username, String password){

        driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
        driver.findElement(By.id("loginUsername")).sendKeys(username, Keys.TAB, password, Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("You Might Also Like"));
        driver.quit();


    }





}
