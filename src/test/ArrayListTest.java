package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @FileName: ArrayListTest.java
 * @Description: ArrayListTest.java类说明
 * @Author: admin
 * @Date: 2021/3/12 18:10
 */
public class ArrayListTest {

    public static void main(String[] args) {
        // public <T> T[] toArray(T[] a) 测试
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        // 如果拷贝数组的大小小于list的长度，返回数组的长度为list的长度
        Integer[] a = new Integer[1];
        Integer[] ans = list.toArray(a);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
        System.out.println("=====================分割线=====================");
        // 如果拷贝数组的大小大于list的长度，返回数组的长度为拷贝数组的大小，后面自动补零
        Integer[] b = new Integer[4];
        ans = list.toArray(b);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

        /*System.out.println("=====================分割线=====================");
        Set<Integer> collection = new HashSet<>();
        collection.add(1);
        boolean isRemoved = list.removeAll(collection);
        System.out.println(isRemoved);*/

        System.out.println("=====================分割线=====================");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.remove();
        }
        System.out.println(list);


    }


}
