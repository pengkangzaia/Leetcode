package myanswer.array.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: No128.java
 * @Description: 最长连续序列
 * @Author: admin
 * @Date: 2020/11/17 11:47
 */
public class No128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                // 保留最大值
                res = Math.max(res, left + right + 1);
                // 当有别的点和这个线段相连的话，只需要知道这条线段的端点保留的信息即可(线段长度)
                map.put(num - left, left + right + 1);
                map.put(num + right, left + right + 1);
                // 还需要更新num位置的信息，因为如果map中之前没有，现在还不插入的话，下一次还会进入if语句
                // 导致num-left和num+right又被更新一次
                map.put(num, left + right + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        No128 no128 = new No128();
        int ans = no128.longestConsecutive(nums);
        System.out.println(ans);
    }

}
