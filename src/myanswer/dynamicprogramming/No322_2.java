package myanswer.dynamicprogramming;

import java.util.Arrays;

/**
 * @FileName: No322_2.java
 * @Description: 二刷零钱兑换
 * @Author: admin
 * @Date: 2020/10/12 10:01
 */
public class No322_2 {

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 需要注意，不能初始化为Integer.MAX_VALUE，
            // 这是因为max_value+1会溢出成为负数，之后进行最小值的比较会出现问题。
            // dp[i] = Integer.MAX_VALUE;
            dp[i] = amount + 1;
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                } else {
                    break;
                }
            }
        }
        // return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int i = Integer.MAX_VALUE;
        int j = i + 1;
        System.out.println(i);
        System.out.println(j);
    }


}
