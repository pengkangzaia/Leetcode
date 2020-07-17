package test;

import org.junit.Test;

public class ClassLoaderTest {

    @Test
    public void classLoaderTest() {
        String a = System.getProperty("java.ext.dirs");
        String b = System.getProperty("java.class.path");
        System.out.println(a);
        System.out.println(b);
    }

}
