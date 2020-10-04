package weeklytest;

/**
 * @FileName: No5518.java
 * @Description: No5518.java类说明
 * @Author: camille
 * @Date: 2020/10/3 23:25
 */
public class No5518 {
    // 看题解之后自己写的，贪心算法。每次选能选的最大值填入数组中

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = Math.min(rowSum[i], colSum[j]);
                res[i][j] = cur;
                rowSum[i] -= cur;
                colSum[j] -= cur;
            }
        }
        return res;
    }

    /*public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] res = new int[m][n];
        int rowMax = max(rowSum);
        int colMax = max(colSum);
        int max = Math.max(rowMax, colMax);

        while (!check(res, rowSum, colSum)) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = (int) (Math.random() * (max+1));
                }
            }
        }
        return res;
    }*/

    private boolean check(int[][] res, int[] rowSum, int[] colSum) {
        int[] myColSum = new int[colSum.length];
        for (int i = 0; i < res.length; i++) {
            int rs = 0;
            for (int j = 0; j < res[0].length; j++) {
                rs += res[i][j];
                myColSum[j] += res[i][j];
            }
            if (rs != rowSum[i]) {
                return false;
            }
        }
        for (int i = 0; i < colSum.length; i++) {
            if (myColSum[i] != colSum[i]) {
                return false;
            }
        }
        return true;

    }

    private int max(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] rowSum = {1,0};
        int[] colSum = {1};
        No5518 no5518 = new No5518();
        int[][] ints = no5518.restoreMatrix(rowSum, colSum);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

}
