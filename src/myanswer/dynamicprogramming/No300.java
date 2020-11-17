package myanswer.dynamicprogramming;

import java.util.Arrays;

/**
 * @FileName: No300.java
 * @Description: 最长上升子序列2刷
 * @Author: admin
 * @Date: 2020/11/17 13:58
 */
public class No300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以i为结尾的（包含i）的最长上升子序列
        int[] dp = new int[n + 1];
        // 最短的子序列为自己一个元素
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[j-1] < nums[i-1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 求所有dp[i]的最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        No300 no300 = new No300();
        int[] nums = {1,3,6,7,9,4,10,5,6};
        int ans = no300.lengthOfLIS(nums);
        System.out.println(ans);
    }

}
