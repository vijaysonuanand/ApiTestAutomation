package local;

import org.testng.annotations.Test;

public class A {

    private TestContext testContext;

    public A(TestContext testContext){
        this.testContext= testContext;
    }


    public void test1(){
        testContext.getScenarioContext().setValue("A", "1");
    }

    public void test2(){

        System.out.println("value fetched is :"+ testContext.getScenarioContext().getValue("A"));
    }

}
