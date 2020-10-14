package myanswer.dynamicprogramming;

/**
 * @FileName: No152.java
 * @Description: 乘积最大数组
 * @Author: camille
 * @Date: 2020/10/14 22:23
 */
public class No152 {

    public int maxProduct(int[] nums) {
        // 二维dp，dp[i][j]为从i到j的乘积，
        // dp[2][4]从dp[2][3]*nums[4],dp[3][4]*nums[2]中取最大值为乘积最大
        // 这不就备忘录吗，哪里来的dp？
//        int n = nums.length;
//        int[][] dp = new int[n + 1][n + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][i] = 0;
//        }
//        for (int len = 1; len <= n; len++) {
//            for (int i = 1; i + len - 1 <= n; i++) {
//                for (int j = i; ) {
//
//                }
//            }
//        }
        return 0;
    }


}
