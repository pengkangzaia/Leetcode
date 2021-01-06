package test;

import java.io.*;

/**
 * @FileName: SerializbleTest.java
 * @Description: SerializbleTest.java类说明
 * @Author: camille
 * @Date: 2020/12/28 20:31
 */
public class SerializableTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setId(1);
        user.setName("彭康");

        // 序列化到文件中
        FileOutputStream fos = new FileOutputStream(new File("UserXX"));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(user);

        // 反序列化文件为对象
        FileInputStream fis = new FileInputStream(new File("UserXX"));
        ObjectInputStream ois = new ObjectInputStream(fis);
        User user1 = (User) ois.readObject();
        System.out.println(user1);
    }


}
