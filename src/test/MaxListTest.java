package test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @FileName: MaxListTest.java
 * @Description: MaxListTest.java类说明
 * @Author: admin
 * @Date: 2021/3/12 11:20
 */
public class MaxListTest {

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<>();
        int num = 1000000;
        for (int i = 0; i < num; i++) {
            list.add(new User(i, "彭康"));
        }
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);

        long time3 = System.currentTimeMillis();
        for (User user : list) {
            System.out.println(user);
        }
        long time4 = System.currentTimeMillis();
        System.out.println(time4 - time3);

        /*long time5 = System.currentTimeMillis();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        long time6 = System.currentTimeMillis();
        System.out.println(time6 - time5);*/
        // 迭代器5秒
        // 增强for 6秒
        // for循环 9秒


    }


}
