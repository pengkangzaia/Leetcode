package daily;

/**
 * @FileName: No304_2.java
 * @Description: 二维区域和检索 - 矩阵不可变
 * @Author: admin
 * @Date: 2021/3/2 10:13
 */
public class No304_2 {

    class NumMatrix {

        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                prefix = matrix;
            } else {
                int m = matrix.length;
                int n = matrix[0].length;
                prefix = new int[m + 1][n + 1];
                for (int i = 1; i <= m; i++) {
                    for (int j = 1; j <= n; j++) {
                        prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + matrix[i - 1][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // ***********************这段很重要******************************** //
            return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
        }
    }


}
