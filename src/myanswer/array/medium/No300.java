package myanswer.array.medium;

import java.util.Arrays;

/**
 * @FileName: No300.java
 * @Description: 最长上升子序列
 * @Author: admin
 * @Date: 2020/10/29 10:57
 */
public class No300 {

    // 不要求子序列中数字连续，返回子序列长度
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;




        // dp[i]表示当前的最大上升子序列长度
        //        if(nums.length == 0) return 0;
        //        int[] dp = new int[nums.length];
        //        int res = 0;
        //        Arrays.fill(dp, 1);
        //        for(int i = 0; i < nums.length; i++) {
        //            for(int j = 0; j < i; j++) {
        //                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
        //            }
        //            res = Math.max(res, dp[i]);
        //        }
        //        return res
    }

    public static void main(String[] args) {
        No300 no300 = new No300();
        int[] nums = {10,9,2,5,3,4};
        int ans = no300.lengthOfLIS(nums);
        System.out.println(ans);
    }

}
