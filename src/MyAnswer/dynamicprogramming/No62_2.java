package MyAnswer.dynamicprogramming;

/**
 * @FileName: No62_2.java
 * @Description: 不同路径，2刷
 * @Author: admin
 * @Date: 2020/9/30 14:37
 */
public class No62_2 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) { return 0; }
        if (m == 1 || n == 1) { return 1; }
        // m行，n列
        int[][] dp = new int[m + 1][n + 1];
        // 初始化最后一行，最后一列
        for (int i = 0; i < m; i++) { dp[i][n - 1] = 1; }
        for (int j = 0; j < n; j++) { dp[m - 1][j] = 1; }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

}
