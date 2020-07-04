package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.UUID;

public class HashMapTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /*HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }*/

        // 1.通过字符串获取Class对象，这个字符串必须带上完整路径名
        Class studentClass = Class.forName("com.test.reflection.Student");
        // 2.获取声明的构造方法，传入所需参数的类名，如果有多个参数，用','连接即可
        Constructor studentConstructor = studentClass.getDeclaredConstructor(String.class);
        // 如果是私有的构造方法，需要调用下面这一行代码使其可使用，公有的构造方法则不需要下面这一行代码
        studentConstructor.setAccessible(true);
        // 使用构造方法的newInstance方法创建对象，传入构造方法所需参数，如果有多个参数，用','连接即可
        Object student = studentConstructor.newInstance("NameA");
        // 3.获取声明的字段，传入字段名
        Field studentAgeField = studentClass.getDeclaredField("studentAge");
        // 如果是私有的字段，需要调用下面这一行代码使其可使用，公有的字段则不需要下面这一行代码
        // studentAgeField.setAccessible(true);
        // 使用字段的set方法设置字段值，传入此对象以及参数值
        studentAgeField.set(student,10);
        // 4.获取声明的函数，传入所需参数的类名，如果有多个参数，用','连接即可
        Method studentShowMethod = studentClass.getDeclaredMethod("show",String.class);
        // 如果是私有的函数，需要调用下面这一行代码使其可使用，公有的函数则不需要下面这一行代码
        studentShowMethod.setAccessible(true);
        // 使用函数的invoke方法调用此函数，传入此对象以及函数所需参数，如果有多个参数，用','连接即可。函数会返回一个Object对象，使用强制类型转换转成实际类型即可
        Object result = studentShowMethod.invoke(student,"message");
        System.out.println("result: " + result);
    }

}
