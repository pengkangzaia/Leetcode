package myanswer.array.medium;

/**
 * @FileName: No378.java
 * @Description: 有序矩阵中的第k个元素
 * @Author: admin
 * @Date: 2020/11/14 9:31
 */
public class No378 {

    // 这题也可以用堆来做

    public int kthSmallest(int[][] matrix, int k) {
        // 二分解法
        int m = matrix.length;
        int n = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[m-1][n-1];
        int mid = 0;
        while (min < max) {
            mid = min + (max - min) / 2;
            // 小于等于mid的元素个数
            int cnt = check(matrix, mid);
            // 如果小于等于mid的元素个数小于k，说明mid不是第k小的数，比mid小的数就更不可能是了。所以第k小的数至少是mid + 1。
            // 如果小于等于mid的元素个数大于等于k，说明mid可能为第k小的数，比它小的数也有可能是答案。
            if (cnt < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public int check(int[][] matrix, int mid) {
        int cnt = 0;
        int i = matrix.length - 1;
        int j = 0;
        while(i >= 0 && j < matrix.length) {
            if (mid >= matrix[i][j]) {
                cnt += i+1;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }

}
