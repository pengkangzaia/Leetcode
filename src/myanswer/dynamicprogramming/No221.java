package myanswer.dynamicprogramming;

/**
 * @FileName: No221.java
 * @Description: 最大正方形
 * @Author: admin
 * @Date: 2020/10/12 19:06
 */
public class No221 {

    // 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // 记录最大值
        int max = Integer.MIN_VALUE;
        // 初始化数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        // 返回dp数组中最大值的平方
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        matrix = null;
//        char[][] matrix1 = new char[0][0];
        No221 no221 = new No221();
        int ans = no221.maximalSquare(matrix);
        System.out.println(ans);
    }

}
