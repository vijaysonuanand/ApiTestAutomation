package seleniumTest.e2e;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.DriverFactory;

public class FirstTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(FirstTest.class);


   @BeforeClass
   void setup(){
       System.out.println("First test before class ");
   }

    @Test
    public void verifyTitle() throws InterruptedException {
        System.out.println("starting the first test 1");
        driver.get("https://www.redbus.in/");
        Thread.sleep(2000);
        System.out.println("current url for verify title is : "+ driver.getTitle());

    }
    @Test
    public void verifyTitle2() throws InterruptedException {
        System.out.println("starting the first test 2");
        driver.get("https://www.redbus.in/");
        Thread.sleep(2000);
        System.out.println("current url for verify title 2 is : "+ driver.getTitle());

    }

    @AfterClass
    public void afterClass(){
        System.out.println("first test after class ");
    }
}

