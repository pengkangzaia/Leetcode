package daily;

/**
 * @FileName: No746.java
 * @Description: 是用最少花费爬楼梯
 * @Author: admin
 * @Date: 2020/12/21 9:42
 */
public class No746 {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.max(dp[n - 1], dp[n - 2]);
    }

}
