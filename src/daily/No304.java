package daily;

/**
 * @FileName: No304.java
 * @Description: 二维区域和检索 - 矩阵不可变
 * @Author: admin
 * @Date: 2021/3/2 9:45
 */
public class No304 {

    static class NumMatrix {

        int[][] prefix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                prefix = matrix;
            } else {
                int m = matrix.length;
                int n = matrix[0].length;
                prefix = new int[m][n + 1];
                for (int i = 0; i < m; i++) {
                    for (int j = 1; j <= n; j++) {
                        prefix[i][j] = prefix[i][j - 1] + matrix[i][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                sum += prefix[i][col2 + 1] - prefix[i][col1];
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[][] m = {{1}};
        NumMatrix matrix = new NumMatrix(m);
        System.out.println(matrix.sumRegion(0, 0, 0, 0));

    }

}
