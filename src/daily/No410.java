package daily;

import java.util.Arrays;

public class No410 {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        // Arrays.fill只能填充一维数组
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0][0] = 0; // 只要小于等于0就可以，因为这是个非负整数数组
        // 记录连续子数组和的一个数组
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k <= i - 1; k++) {
                    // k值是数组前k个数字之和
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        No410 no410 = new No410();
        int[] nums = {7, 2, 5, 10, 8};
        int ans = no410.splitArray(nums, 2);
        System.out.println(ans);
    }

}
