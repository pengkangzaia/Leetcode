package myanswer.array.medium;

import java.util.*;

/**
 * @FileName: No220.java
 * @Description: 存在重复元素3
 * @Author: admin
 * @Date: 2020/12/9 18:51
 */
public class No220 {

    // 暴力解法，不出意料会超时
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        long[] arrays = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arrays[i] = nums[i];
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                long abs1 = Math.abs(arrays[i] - arrays[j]);
                int abs2 = Math.abs(i - j);
                if (abs1 <= t && abs2 <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    // 用 TreeSet 里面的自平衡二叉搜索树
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        // 树中的元素是有序的
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No220 no220 = new No220();
        int[] nums = {1,2,3,1};
        boolean ans = no220.containsNearbyAlmostDuplicate1(nums, 3, 0);
        System.out.println(ans);
    }

}
