package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: No54.java
 * @Description: 每日一题，螺旋矩阵
 * @Author: admin
 * @Date: 2021/3/15 9:35
 */
public class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        int left = 0, right = n - 1, up = 0, down = m - 1;
        int currRow = 0, currCol = 0;
        while (true) {
            while (currCol <= right) {
                res.add(matrix[currRow][currCol++]);
            }
            up++;
            if (up > down) break;
            currRow = up;
            currCol = right;
            while (currRow <= down) {
                res.add(matrix[currRow++][currCol]);
            }
            right--;
            if (right < left) break;
            currRow = down;
            currCol = right;
            while (currCol >= left) {
                res.add(matrix[currRow][currCol--]);
            }
            down--;
            if (down < up) break;
            currRow = down;
            currCol = left;
            while (currRow >= up) {
                res.add(matrix[currRow--][currCol]);
            }
            left++;
            if (left > right) break;
            currRow = up;
            currCol = left;
        }
        return res;
    }

    public static void main(String[] args) {
        No54 no54 = new No54();
        int[][] matrix = {
                {2,5,8},
                {4,0,1}
        };
        List<Integer> ans = no54.spiralOrder(matrix);
        System.out.println(ans);
    }


}
