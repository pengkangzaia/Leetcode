package myanswer.slidingwindow;

import java.util.Arrays;

/**
 * @FileName: No480.java
 * @Description: 滑动窗口中位数
 * @Author: admin
 * @Date: 2021/2/3 10:22
 */
public class No480 {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (k == 0) return new double[0];
        double[] ans = new double[nums.length - k + 1];
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        for (int i = k; i <= nums.length; i++) { // 总共有n-k+1个结果
            ans[i - k] = (double) ((long) window[k / 2] + (long) window[ (k - 1) / 2]) / 2;
            if (i == nums.length) break;
            remove(window, nums[i - k]); // 移除最开始进入的元素
            insert(window, nums[i]); // 插入最新的元素
        }
        return ans;
    }

    private void remove(int[] window, int val) {
        int i = 0;
        while (i < window.length && val != window[i]) i++; // 找到val的下标
        while (i < window.length - 1) window[i] = window[++i]; // 后面的元素覆盖前面的元素
    }

    private void insert(int[] window, int val) {
        int i = 0;
        // 在插入之前进行了remove操作，所以window[k-1]的位置是空的
        while (i < window.length - 1 && val > window[i]) i++; // 找到第一个大于val的元素的下标
        int j = window.length - 1;
        while (i < j) window[j] = window[--j]; // 将j前面的一个元素复制到后面去
        window[i] = val;
    }

    public static void main(String[] args) {
        No480 no480 = new No480();
        int[] nums = {2147483647,2147483647};
        double[] ans = no480.medianSlidingWindow(nums, 2);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }


}
