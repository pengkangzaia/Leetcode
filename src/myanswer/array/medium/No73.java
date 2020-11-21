package myanswer.array.medium;

import java.util.HashSet;

/**
 * @FileName: No73.java
 * @Description: 矩阵置零
 * @Author: camille
 * @Date: 2020/11/21 18:49
 */
public class No73 {

    // 方法1
    public void setZeroes(int[][] matrix) {
        // 空间复杂度o(m+n)
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 方法2 o(1)的空间复杂度
    public void setZeroes1(int[][] matrix) {
        boolean colSetZero = false;

        for (int i = 0; i < matrix.length; i++) {
            // 如果第一列就为0，那么只需要设置第一列的元素为0就可以（flag为colSetZero）
            if (matrix[i][0] == 0) {
                colSetZero = true; // 第一列要置为0
            }
            // 处理其他列
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0; // 行的第一个元素置为0，表示行中所有元素都为0
                    matrix[0][j] = 0; // 列中第一个元素置为0，表示列中所有元素都为0
                }
            }
        }

        // 从第二行和第二列开始，因为第一行和第一列该置为0的已经置为0了
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 下面开始处第一行和第一列
        // 之前没改变[0][0]位置元素的值，只是设置了标志位
        if (matrix[0][0] == 0) {
            // 设置第一行为0
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colSetZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
