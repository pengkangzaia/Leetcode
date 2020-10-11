package myanswer.dynamicprogramming;

/**
 * @FileName: No375.java
 * @Description: 猜数字大小2
 * @Author: camille
 * @Date: 2020/10/10 20:49
 */
public class No375 {

    public int getMoneyAmount(int n) {
        // 给定n，最少需要多少才能确保赢下游戏
        // 动态规划三要素
        // 最优子结构：满足，最少需要的钱
        // 重叠子问题：
        // 转移方程：dp[i] = dp[i - k] + k  for k in 1..i
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }
        }
        return dp[1][n];
    }

    public int getMoneyAmount1(int n) {
        // 三重for循环
        int[][] dp = new int[n+1][n+1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int temp = Integer.MAX_VALUE;
                // end = start + len - 1;
                // n = 1 + (n) - 1
                for (int j = i; j + 1 <= i + len - 1; j++) {
                    temp = Math.min(temp, j + Math.max(dp[i][j-1], dp[j+1][i+len-1]));
                }
                dp[i][i+len-1] = temp;
            }
        }
        return dp[1][n];
    }


}
