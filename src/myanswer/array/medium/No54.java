package myanswer.array.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No54.java
 * @Description: 螺旋矩阵
 * @Author: admin
 * @Date: 2020/10/21 17:40
 */
public class No54 {

    // 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length;;
        int n = matrix[0].length;
        int count = (Math.min(m, n) + 1) / 2; // 要遍历的层数
        int i = 0; // 从第一层开始
        while (i < count) {
            for (int j = i; j < n-i; j++) {
                res.add(matrix[i][j]);
            }
            for (int j = i+1; j < m-i; j++) {
                res.add(matrix[j][n-i-1]);
            }
            // n-i-1表示最后，n-i-1-1表示除去最后一个
            // 这里是j>=i不是>=0
            for (int j = n-i-1-1; j >=i && m-i-1!=i; j--) {
                res.add(matrix[m-i-1][j]);
            }
            for (int j = m-1-i-1; j>i && n-1-i!=i; j--) {
                res.add(matrix[j][i]);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        No54 no54 = new No54();
        int[][] matrix = {
                {1,2,3,4},
//                {4,5,6,5},
//                {7,8,9,6},
                {1,2,3,4}
        };
        List<Integer> ans = no54.spiralOrder2(matrix);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

    public List<Integer> spiralOrder1(int[][] matrix) {
        // 设置边界，遍历的同时更新边界
        List<Integer> res = new LinkedList<Integer>();
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true) {
            for (int i = l; i <= r; ++i) {
                res.add(matrix[u][i]);
            }
            if (++u > d) { break; }
            for (int i = u; i <= d; ++i) {
                res.add(matrix[i][r]);
            }
            if (--r < l) { break; }
            for (int i = r; i >= l; --i) {
                res.add(matrix[d][i]);
            }
            // 这里是小于
            if (--d < u) { break; }
            for (int i = d; i >= u; --i) {
                res.add(matrix[i][l]);
            }
            if (++l > r) { break; }
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; ++col) {
                res.add(matrix[up][col]);
            }
            if (++up > down) {
                break;
            }
            for (int row = up; row <= down; ++row) {
                res.add(matrix[row][right]);
            }
            if (--right < left) {
                break;
            }
            for (int col = right; col >= left; --col) {
                res.add(matrix[down][col]);
            }
            if (--down < up) {
                break;
            }
            for (int row = down; row >= up; --row) {
                res.add(matrix[row][left]);
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }

}
