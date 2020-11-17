package myanswer.dfsandbfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No329.java
 * @Description: 矩阵中的最长递增路径
 * @Author: admin
 * @Date: 2020/11/17 15:19
 */
public class No329 {

    private int res = 1;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    // 直接DFS会超时，用记忆化搜索
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (memo[i][j] != 1) {
            return memo[i][j];
        }
        for (int[] direction : directions) {
            int newRow = i + direction[0];
            int newCol = j + direction[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[i][j] < matrix[newRow][newCol]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, newRow, newCol, memo) + 1);
            }
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 4, 5},
                {3, 4, 6}
        };
        No329 no329 = new No329();
        int ans = no329.longestIncreasingPath(nums);
        System.out.println(ans);
    }


}
