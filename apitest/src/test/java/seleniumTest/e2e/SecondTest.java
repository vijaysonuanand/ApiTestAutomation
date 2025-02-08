package seleniumTest.e2e;

import base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SecondTest.class);


   @BeforeClass
   void setup() {
       System.out.println("second test before class ");
   }

    @Test
    public void VerifyCurrentUrl() {
        driver.get("https://www.redbus.in/");
        System.out.println("starting the second test");
        System.out.println("current url for second test is : "+ driver.getCurrentUrl());

    }

    @AfterClass
    public void afterClass(){
        System.out.println("second test after class ");
    }
}

