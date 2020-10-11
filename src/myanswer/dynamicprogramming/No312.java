package myanswer.dynamicprogramming;

/**
 * @FileName: No312.java
 * @Description: 戳气球
 * @Author: camille
 * @Date: 2020/10/11 22:16
 */
public class No312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arrays = new int[n + 2];
        arrays[0] = 1;
        arrays[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            arrays[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + arrays[i] * arrays[k] * arrays[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

}
