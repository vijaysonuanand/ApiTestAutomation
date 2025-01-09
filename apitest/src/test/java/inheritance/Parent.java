package inheritance;

public class Parent {
    String common = "Parent common ";
    int parentId = 20;
    String parentName = "John parent";

    Parent() {
        System.out.println("default Parent constructor called");
    }

    Parent(String message) {
        System.out.println("parameterised  Parent constructor called : " + message);
    }

    void test() {
        System.out.println(" this is parent overridden method call ");
    }

    void testParent() {
        System.out.println(" this is parent specific method call ");
    }
}
