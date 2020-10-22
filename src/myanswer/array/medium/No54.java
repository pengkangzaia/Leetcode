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
                {4,5,6,5},
                {7,8,9,6},
                {1,2,3,4}
        };
        List<Integer> ans = no54.spiralOrder(matrix);
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }

}
