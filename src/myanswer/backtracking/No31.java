package myanswer.backtracking;

import java.util.Arrays;

/**
 * @FileName: No31.java
 * @Description: No31.java类说明
 * @Author: 彭康
 * @Date: 2020/9/24 9:48
 */
public class No31 {

    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[i - 1] < nums[j]) {
                        swap(nums, i - 1, j);
                        Arrays.sort(nums, i, nums.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        No31 no31 = new No31();
        int[] nums = {1,5,2,3,0,0,2};
        no31.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
