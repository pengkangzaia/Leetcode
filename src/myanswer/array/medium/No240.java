package myanswer.array.medium;

/**
 * @FileName: No240.java
 * @Description: No240.java类说明
 * @Author: camille
 * @Date: 2020/10/26 21:52
 */
public class No240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while(i <= m-1 && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        // 只要跳出循环，就表示找不到
        return false;
    }

    public static void main(String[] args) {
        No240 no240 = new No240();
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] ma = {{1,1}};
        boolean ans = no240.searchMatrix(matrix, 20);
        System.out.println(ans);
    }


}
