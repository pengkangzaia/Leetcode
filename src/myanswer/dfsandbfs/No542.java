package myanswer.dfsandbfs;

/**
 * @FileName: No542.java
 * @Description: 01矩阵
 * @Author: camille
 * @Date: 2021/2/27 20:05
 */
public class No542 {

    private int[] directionX = {1, -1, 0, 0};
    private int[] directionY = {0, 0, 1, -1};
    private int maxValue;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        maxValue = m + n + 1;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    res[i][j] = search(matrix, visited, i, j);
                }
            }
        }
        return res;
    }

    private int search(int[][] matrix, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
            return maxValue;
        }
        if (matrix[row][col] == 0) {
            return 0;
        } else {
            if (!visited[row][col]) {
                int ans = maxValue;
                visited[row][col] = true;
                for (int i = 0; i < 4; i++) {
                    ans = Math.min(ans, search(matrix, visited, row + directionX[i], col + directionY[i]));
                }
                visited[row][col] = false;
                return ans + 1;
            }
        }
        return maxValue;
    }


}
