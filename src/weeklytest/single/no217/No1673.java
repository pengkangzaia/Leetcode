package weeklytest.single.no217;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @FileName: No1673.java
 * @Description: 找出最具竞争力的子序列
 * @Author: camille
 * @Date: 2020/12/6 11:48
 */
public class No1673 {

   /* public int[] mostCompetitive(int[] nums, int k) {
        // 最小的递增子序列
        // 或者用贪心来解
        *//*LinkedList<Integer> list = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (list.size() < k) {
                list.addFirst(nums[i]);
                continue;
            }
            if (nums[i] < list.get(0)) {
                list.removeFirst();
                list.addFirst(nums[i]);
            } else if (nums[i] == list.get(0)) {
                list.removeFirst();
                mostCompetitive(Integer[] list.toArray(), k - 1);
                list.addFirst(nums[i]);
                list.addFirst(nums[i]);

            }
        }*//*
    }*/

}
