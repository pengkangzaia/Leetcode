package daily;

/**
 * @FileName: No73.java
 * @Description: No73.java类说明
 * @Author: camille
 * @Date: 2021/3/21 13:16
 */
public class No73 {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zero = matrix[0][0] == 0;
        boolean firstColZ = false;
        for (int i = 0; i < m; i++) {
            firstColZ = firstColZ || (matrix[i][0] == 0);
        }
        boolean firstRowZ = false;
        for (int i = 0; i < n; i++) {
            firstRowZ = firstRowZ || (matrix[0][i] == 0);
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (zero) {
            for (int i = 1; i < m; i++) {
                matrix[i][0] = 0;
            }
            for (int i = 1; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColZ) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZ) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        No73 no73 = new No73();
        int[][] matrix = {{1, 0}};
        no73.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
