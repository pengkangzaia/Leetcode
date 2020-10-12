package myanswer.dynamicprogramming;

import myanswer.string.No6;

/**
 * @FileName: No64.java
 * @Description: 最小路径和
 * @Author: admin
 * @Date: 2020/10/12 10:45
 */
public class No64 {

    // 只能向下或者向右移动一步
    // dp[i][j]表示从

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] + grid[m - 1][i + 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = dp[i + 1][n - 1] + grid[i + 1][n - 1];
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j] + grid[i + 1][j],
                        dp[i][j + 1] + grid[i][j + 1]);
            }
        }
        return dp[0][0] + grid[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        No64 no64 = new No64();
        int sum = no64.minPathSum(grid);
        System.out.println(sum);
    }

}
