package local;

import org.testng.annotations.Test;

public class B {

    TestContext context = new TestContext();

    @Test
    public void FirstTest() {
        A a = new A(context);
        a.test1();
        a.test2();
    }
}
