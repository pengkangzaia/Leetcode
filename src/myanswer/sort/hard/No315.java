package myanswer.sort.hard;

import myanswer.linkedlist.medium.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No315.java
 * @Description: 计算右侧小于当前元素的个数
 * @Author: admin
 * @Date: 2020/11/17 9:45
 */
public class No315 {

    // 暴力解法，超时
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i+1; j < n; j++) {
                if (cnt < nums[i]) {
                    cnt++;
                }
            }
            res.add(cnt);
        }
        return res;
    }

    // 从后向前遍历，同时排序最后一个元素到当前元素构成的子数组
    public List<Integer> countSmaller1(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int n = nums.length - 1;
        List<Integer> sorted = new ArrayList<>(n+1);
        Integer[] res = new Integer[n + 1];
        res[n] = 0;
        sorted.add(nums[n]);
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            res[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> sorted, int num) {
        int left = 0;
        int right = sorted.size() - 1;
        int mid = 0;
        // 找到比num小的最大元素的位置
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (num > sorted.get(mid)) {
                // mid值不行
                left = mid + 1;
            } else {
                // 循环退出时，right<left，left=比num大的最小元素位置
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        No315 no315 = new No315();
        int[] nums = {-1, -1};
        List<Integer> ans = no315.countSmaller1(nums);
        System.out.println(ans);
    }

}
