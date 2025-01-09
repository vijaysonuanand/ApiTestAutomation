package inheritance;

class Student {
    String name;
    int age;

    // Constructor 1: Accepts both name and age
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Constructor 2: Only accepts name, calls the first constructor to set default age
    public Student(String name) {
        this(name, 18);  // Calls Constructor 1 with default age
    }

    // Constructor 3: Default constructor, sets default values
    public Student() {
        this("Unknown");  // Calls Constructor 2 with default name
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Student s1 = new Student("John", 20);
        Student s2 = new Student("Alice");
        Student s3 = new Student();

        s1.display();
        s2.display();
        s3.display();
    }
}