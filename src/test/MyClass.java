package test;

public class MyClass implements MyInterface{

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        if (myClass instanceof MyInterface) {
            System.out.println(true);
        }
        System.out.println(myClass);
        MyInterface myInterface = myClass;
        System.out.println(myInterface);
        Object o = new String("1");
        String s = (String) new Object();

    }

}
