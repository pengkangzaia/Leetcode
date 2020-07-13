package MyAnswer.array.medium;

public class No64 {

    public int minPathSum(int[][] grid) {
        /*if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }*/
        // dp[i][j] = grid[i][j] + min(dp[i-1][j],dp[i][j-1]);
        int m = grid.length;
        int n = grid[0].length;
        // m 行 n 列
        int[][] dp = new int[m][n];
        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = dp[i][j + 1] + grid[i][j];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = dp[i + 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i][j + 1], dp[i + 1][j]) + grid[i][j];
                }
            }
        }

        return dp[0][0];
    }

}
