package myanswer.dynamicprogramming;

import java.util.Arrays;

/**
 * @FileName: No174.java
 * @Description: No174.java类说明
 * @Author: admin
 * @Date: 2020/10/12 17:25
 */
public class No174 {
    // 这个要返回来看，todo
    public int calculateMinimumHP(int[][] dungeon) {
        // dp为当前格所需要的最小健康点数
        // 仔细看看题目，理解错了
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // 这一步很关键
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);;
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, dp[m - 1][i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }

}
