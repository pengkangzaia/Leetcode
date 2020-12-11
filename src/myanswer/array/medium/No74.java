package myanswer.array.medium;

/**
 * @FileName: No74.java
 * @Description: 搜索二维矩阵
 * @Author: admin
 * @Date: 2020/12/10 14:26
 */
public class No74 {

    // o(m+n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        // row为所在行的下一行，最大为m.这一步初始化是关键
        int row = m;
        for (int i = 0; i < m; i++) {
            if (target == matrix[i][0]) {
                return true;
            } else if (target < matrix[i][0]){
                if (i == 0) { return false; }
                row = i;
                break;
            }
        }
        // 找所在列
        for (int i = 0; i < n; i++) {
            if (target == matrix[row-1][i]) {
                return true;
            } else if (target < matrix[row-1][i]) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        No74 no74 = new No74();
        boolean ans = no74.searchMatrix(matrix, 3);
        System.out.println(ans);

    }


}
