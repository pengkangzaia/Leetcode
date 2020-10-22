package myanswer.array.medium;

/**
 * @FileName: No59.java
 * @Description: 螺旋矩阵
 * @Author: admin
 * @Date: 2020/10/22 11:51
 */
public class No59 {

    // 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int i = 0;
        int count = (n + 1) / 2; // 遍历层数
        int num = 1;
        while (i < count) {
            for (int j = i; j < n - i; j++) {
                res[i][j] = num;
                num++;
            }
            for (int j = i + 1; j <= n - 1 - i; j++) {
                res[j][n - 1 - i] = num;
                num++;
            }
            for (int j = n - 1 - i - 1; j >= i && n - 1 - i != i; j--) {
                res[n - i - 1][j] = num;
                num++;
            }
            // j > i
            for (int j = n - 1 - i - 1; j > i && n - 1 - i != i; j--) {
                res[j][i] = num;
                num++;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        No59 no59 = new No59();
        int[][] ans = no59.generateMatrix(4);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

}
