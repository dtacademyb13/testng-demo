package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ConfigurationAnnotations {


    @BeforeGroups (groups = "smoke")
    public void setupGroup(){
                System.out.println("Smoke tests BEFORE SETUP");
    }
    @AfterGroups (groups = "smoke")
    public void tearDownGroup(){
        System.out.println("Smoke tests AFTER TEARDOWN");
    }



 WebDriver driver;


   @BeforeSuite
   public void beforeSuite(){

       System.out.println("Before Suite: establishing db connection, creating a report object");
   }



    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite: tearing down db connection, generate the report");

    }


    @BeforeTest
    public void beforetest(){
        System.out.println("Before Test subcategory");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("After Test subcategory");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }


    @BeforeMethod (alwaysRun = true)
    public void setup(){
        System.out.println("Before Method");
        driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(){
        System.out.println("After Method");
        driver.quit();
    }


    @Test (groups = {"smoke", "flaky", "googleSearch"} )
    public void testGoogle(){
        System.out.println("test 1");
        driver.get("https://www.google.com/");
        String searchTerm = "coffee mug";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));

    }

    @Test (groups = "smoke")
    public void testGoogle2(){
        System.out.println("test 2");
        driver.get("https://www.google.com/");
        String searchTerm = "coffee";
        driver.findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(searchTerm));

    }
}
