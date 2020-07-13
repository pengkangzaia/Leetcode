package test;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class FailSafe {

    public static void main(String[] args)
    {
        // 迭代器并不能访问到修改后的内容，
        // 即：迭代器遍历的是开始遍历那一刻拿到的集合拷贝，
        // 在遍历期间原集合发生的修改迭代器是不知道的。
        ConcurrentHashMap<String,String> premiumPhone =
                new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S5");

        Iterator iterator = premiumPhone.keySet().iterator();

        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }

    }

}
