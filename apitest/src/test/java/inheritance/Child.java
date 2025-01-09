package inheritance;

public class Child extends Parent implements TestInterface{
    String common = "child common ";
    int childId= 10;
    String childName = "John";

    Child(){
       // super();
        System.out.println("Child default constructor called");
    }

    Child(String message ){
        super(message);
        System.out.println("Child parameterised  constructor called : " + message);
    }


    void test(){
        System.out.println(" this is child method overriden call ");
    }

    void testChild(){
        System.out.println(" this is child specific method call ");
    }

    public static  void main (String args[]){
        Parent p = new Parent();
        p.test();
        p.testParent();
        System.out.println("calling variable with parent reference : " + p.parentId + " " + p.parentName +" "+ p.common);
        System.out.println("=================================");

        Parent p1 = new Child();
        p1.test();
        p1.testParent();
        System.out.println("calling variable with parent - new child reference : " + p1.parentId + " " + p1.parentName + " "+ p1.common);

        System.out.println("=================================");
        Child c1 = new Child();
        c1.test();
        c1.testParent();
        c1.testChild();
        System.out.println("calling parent variable with  child reference : " + c1.parentId + " " + c1.parentName +" " + c1.common);
        System.out.println("calling child  variable with  child reference : " + c1.childId + " " + c1.childName);

    }

    @Override
    public void show() {
        System.out.println("This is show method implementation call");
    }
}
