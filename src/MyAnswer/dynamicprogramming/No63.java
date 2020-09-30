package MyAnswer.dynamicprogramming;

/**
 * @FileName: No63.java
 * @Description: No63.java类说明
 * @Author: admin
 * @Date: 2020/9/30 15:26
 */
public class No63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 有可能路被堵死，一条路径都没有
        for (int j = n - 1; j >= 0; j--) {
            // 最后一行
            if (obstacleGrid[m-1][j] == 1) { break; }
            dp[m-1][j] = 1;
        }
        if (m == 1) { return dp[0][0]; }
        for (int i = m - 1; i >= 0; i--) {
            // 最后一列
            if (obstacleGrid[i][n-1] == 1) { break; }
            dp[i][n-1] = 1;
        }
        if (n == 1) { return dp[0][0]; }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) { continue; }
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        No63 no63 = new No63();
        int[][] obstacleGrid = new int[1][2];
        obstacleGrid[0] = new int[]{0, 1};
        int i = no63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

}
