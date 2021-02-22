package myanswer.array.easy;

/**
 * @FileName: No766.java
 * @Description: 托普利兹矩阵
 * @Author: admin
 * @Date: 2021/2/22 9:35
 */
public class No766 {

    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            // 判断是否相等
            int row = i, col = 0;
            while (col < n - 1 && row < m - 1) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
                row++;
                col++;
            }
        }

        for (int i = 0; i < n; i++) {
            // 判断是否相等
            int row = 0, col = i;
            while (row < m - 1 && col < n - 1) {
                if (matrix[row][col] != matrix[row + 1][col + 1]) {
                    return false;
                }
                row++;
                col++;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        No766 no766 = new No766();
        int[][] m = {
                {1, 2, 3},
                {2, 1, 2}
        };
        boolean asn = no766.isToeplitzMatrix(m);
        System.out.println(asn);
    }

}
