package myanswer.backtracking;

import java.util.Arrays;

/**
 * @FileName: No31.java
 * @Description: 下一个排列
 * @Author: 彭康
 * @Date: 2020/9/24 9:48
 */
public class No31 {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            // 如果后面的数字大于前面的数字（暗示i后面的数字都是单调递减的）
            if (nums[i - 1] < nums[i]) {
                // 从i到nums.length-1的位置，找到第一个比i-1大的元素。
                // 从后往前找第一个比i-1大的元素。这样可以确保
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[i - 1] < nums[j]) {
                        swap(nums, i - 1, j);
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        // 如果所有前面的数字都比后面的数字大，则返回最小的数字
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        No31 no31 = new No31();
        int[] nums = {1, 5, 2, 3, 0, 4, 8, 5, 3};
        // 比如这个例子：4853
        // 那么下一个大的就是 5348
        no31.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
