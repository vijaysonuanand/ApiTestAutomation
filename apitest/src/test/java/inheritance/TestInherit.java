package inheritance;

public class TestInherit {

    public static void main(String[] args) {

        //Child c = new Child();
        //Child c1 = new Child("hello");


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


        System.out.println("=================================");
        //Child c2 = new Parent();  // this will give compile error

        System.out.println("============Interface check============");

        TestInterface i1 = new Child() ;
       // TestInterface i2 = new Parent() ; // this is not possible as child class is implementing the interface

    }
}
