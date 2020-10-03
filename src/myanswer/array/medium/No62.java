package myanswer.array.medium;

public class No62 {

    private int count = 0;

    public int uniquePaths(int m, int n) {
        // 1 <= m, n <= 100
        // 不用考虑不能形成矩阵的情况
        // 其实不用考虑之前的状态，不会返回到之前的状态
        // boolean[][] used = new boolean[m][n];
        // 回溯法添加路径
        // 开始坐标，目标坐标
        dfs(0, 0, m - 1, n - 1);
        return count;
    }

    private void dfs(int x, int y, int endX, int endY) {

        if (x == endX && y == endY) {
            count++;
            return;
        }
        if (x > endX || y > endY || x < 0 || y < 0) {
            return;
        }
        // used[x][y] = true;
        dfs(x + 1, y, endX, endY);
        dfs(x, y + 1, endX, endY);
        // used[x][y] = false;
    }

    /**
     * 动态规划法
     */
    public int uniquePathsDP(int m, int n) {
        // dp数组存到[i][j]的路径数
        int[][] dp = new int[m][n];
        // dp数组的初始值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        No62 no62 = new No62();
        int ans = no62.uniquePaths(50, 23);
        System.out.println(ans);
    }

}
