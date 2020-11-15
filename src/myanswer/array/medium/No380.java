package myanswer.array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @FileName: No380.java
 * @Description: 常数时间插入、删除和获取随机元素
 * @Author: admin
 * @Date: 2020/11/15 14:39
 */
public class No380 {

    class RandomizedSet {

        private HashMap<Integer, Integer> map;
        private ArrayList<Integer> list;
        private Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
            this.random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            } else {
                map.put(val, list.size());
                list.add(list.size(), val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int idx = map.get(val);
                int last = list.get(list.size() - 1);
                list.set(idx, last);
                list.remove(list.size() - 1);
                map.put(last, idx);
                map.remove(val);
                return true;
            } else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int idx = random.nextInt(list.size());
            return list.get(idx);
        }

    }

    public static void main(String[] args) {
        No380 no380 = new No380();
        RandomizedSet set = no380.new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }

}
