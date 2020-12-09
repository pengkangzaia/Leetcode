package daily;

/**
 * @FileName: No861.java
 * @Description: 翻转矩阵后的得分
 * @Author: admin
 * @Date: 2020/12/7 10:51
 */
public class No861 {

    // 有一个二维矩阵A 其中每个元素的值为0或1。
    // 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
    // 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
    // 返回尽可能高的分数。

    /**
     * 0011        1111
     * 1010  -->   1001
     * 1100        1111
     */
    // 1100     1111
    // 1010     1001
    // 1100     1111
    // 第一列为全1，第二列开始的列中。0个数多的转为1个数多的
    public int matrixScore(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        for (int i = 0; i < m; i++) {
            if (nums[i][0] == 0) {
                flipRow(nums, i);
            }
        }
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += nums[j][i];
            }
            if (sum <= m / 2) {
                flipCol(nums, i);
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += nums[i][j] * (int) Math.pow(2, n - j - 1);
                // System.out.print(nums[i][j] + " ");
            }
            // System.out.println();
            res += sum;
        }
        return res;
    }

    private void flipCol(int[][] nums, int j) {
        for (int i = 0; i < nums.length; i++) {
            nums[i][j] = nums[i][j] == 1 ? 0 : 1;
        }
    }

    private void flipRow(int[][] nums, int i) {
        for (int j = 0; j < nums[i].length; j++) {
            nums[i][j] = nums[i][j] == 1 ? 0 : 1;
        }
    }

    public static void main(String[] args) {
        No861 no861 = new No861();
        int[][] nums = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        no861.matrixScore(nums);
    }


}
