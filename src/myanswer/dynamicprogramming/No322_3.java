package myanswer.dynamicprogramming;

import java.util.Arrays;

/**
 * @FileName: No322_3.java
 * @Description: 三刷零钱兑换
 * @Author: admin
 * @Date: 2020/11/17 14:11
 */
public class No322_3 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        No322_3 no322_3 = new No322_3();
        int[] coins = {1,2,5};
        int ans = no322_3.coinChange(coins, 11);
        System.out.println(ans);
    }

}
