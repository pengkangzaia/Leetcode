package myanswer.dynamicprogramming;

import java.util.Arrays;

/**
 * @FileName: No279_2.java
 * @Description: 完全平方数二刷
 * @Author: admin
 * @Date: 2020/11/17 13:41
 */
public class No279_2 {

    public int numSquare(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (sqrt * sqrt != i) {
                // 可优化
                /*for (int j = 1; j < i; j++) {
                    dp[i] = Math.min(dp[i], dp[i-j] + dp[j]);
                }*/
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i-j * j] + 1);
                }
            } else {
                dp[i] = 1;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No279_2 no279_2 = new No279_2();
        int ans = no279_2.numSquare(12);
        System.out.println(ans);
    }



}
