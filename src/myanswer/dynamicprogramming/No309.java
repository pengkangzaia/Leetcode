package myanswer.dynamicprogramming;

/**
 * @FileName: No309.java
 * @Description: 最佳买卖股票时机含冷冻期
 * @Author: admin
 * @Date: 2020/10/29 14:05
 */
public class No309 {

    // 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
    //
    // 设计一个算法计算出最大利润。在满足以下约束条件下，
    // 你可以尽可能地完成更多的交易（多次买卖一支股票）:
    //
    // 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    // 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

    public int maxProfit(int[] prices) {
        // 三维dp
        int n = prices.length;
        int[][] dp = new int[n][3];
        // 前提是每天最多只能持有一个股票
        // dp[i][0]表示截至第i天的收益，状态为持有股票
        // dp[i][1]表示截至第i天的收益，状态为没有股票，明天处于冷冻期
        // dp[i][2]表示截至第i天的收益，状态为没有股票，明天不处于冷冻期
        // dp[i][0]= max(dp[i-1][0],dp[i-1][2]-prices[i]) 原来有股票第i天不进行操作，原来没有第i天买入
        // dp[i][1]= dp[i-1][0]+prices[i] 今天卖出股票，明天处于冷冻期
        // dp[i][2]= max(dp[i-1][2],dp[i-1][1]) 今天没有股票，前一天要么没有冷冻期，要么有冷冻期
        dp[0][0] = -1 * prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]= dp[i-1][0]+prices[i];
            dp[i][2]= Math.max(dp[i-1][2],dp[i-1][1]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

    public static void main(String[] args) {
        No309 no309 = new No309();
        int[] prices = {1,2,3,4};
        int ans = no309.maxProfit(prices);
        System.out.println(ans);
    }


}
