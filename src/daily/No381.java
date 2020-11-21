package daily;

import java.util.*;

/**
 * @FileName: No381.java
 * @Description: O(1)时间插入，删除和获取随机元素-允许重复
 * @Author: camille
 * @Date: 2020/10/31 11:47
 */
public class No381 {

    static class RandomizedCollection {

        Map<Integer, Set<Integer>> idx;
        List<Integer> nums;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            idx = new HashMap<Integer, Set<Integer>>();
            nums = new ArrayList<Integer>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            nums.add(val);
            Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
            set.add(nums.size() - 1);
            idx.put(val, set);
            return set.size() == 1;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (!idx.containsKey(val)) {
                return false;
            }
            Iterator<Integer> it = idx.get(val).iterator();
            int i = it.next();
            int lastNum = nums.get(nums.size() - 1);

            // 有可能val=lastNum,但是i和num.size()-1不相等
            // 如果remove i写在后面，会把前面的add(i)的操作覆盖
            idx.get(val).remove(i);
            idx.get(lastNum).remove(nums.size() - 1);
            if (i < nums.size() - 1) {
                idx.get(lastNum).add(i);
            }

            if (idx.get(val).size() == 0) {
                idx.remove(val);
            }
            nums.set(i, lastNum);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            return nums.get((int) (Math.random() * nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        boolean flag = false;
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(0);
        System.out.println(flag);
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(1);
        System.out.println(flag);
        flag = rc.insert(0);
        System.out.println(flag);
        flag = rc.remove(0);
        System.out.println(flag);
        flag = rc.remove(0);
        System.out.println(flag);
        System.out.println(rc.getRandom());

    }

}
