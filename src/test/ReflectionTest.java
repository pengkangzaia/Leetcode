package test;

import sword2offer.Node;

public class ReflectionTest {

    public static void main(String[] args) {
        // 反射API练习
        Node node = new Node(0);
        Class nodeClass = node.getClass();
        Class<? extends Node> nodeClass1 = node.getClass();
        System.out.println(nodeClass.getClassLoader());
        System.out.println(nodeClass.getName());
        Class[] classes = nodeClass.getClasses();
        for (Class aClass : classes) {
            System.out.println(aClass);
        }
    }

}
