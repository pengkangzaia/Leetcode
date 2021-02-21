package myanswer.slidingwindow;

import java.util.TreeMap;

/**
 * @FileName: No1438.java
 * @Description: 绝对差不超过限制的最长连续子数组
 * @Author: camille
 * @Date: 2021/2/21 20:24
 */
public class No1438 {

    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int left = 0, right = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // key为元素，value为元素个数
        while (right < nums.length) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.firstKey() - treeMap.lastKey() > limit) {
                treeMap.put(nums[left], treeMap.get(nums[left]) - 1);
                if (treeMap.get(nums[left]) == 0) {
                    treeMap.remove(nums[left]);
                    left++;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }


}
