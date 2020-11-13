package myanswer.array.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * @FileName: No384.java
 * @Description: 打乱数组
 * @Author: admin
 * @Date: 2020/11/13 10:46
 */
public class No384 {

    static class Solution {

        private int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return this.nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] shuffled = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                shuffled[i] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                Random random = new Random();
                int idx = random.nextInt(nums.length - i) + i;
                int temp = shuffled[i];
                shuffled[i] = shuffled[idx];
                shuffled[idx] = temp;
            }
            return shuffled;
        }
    }

    public static void main(String[] args) {
        No384 no384 = new No384();
        int[] nums = {1,2,3,4,5};
        Solution solution = new Solution(nums);
        int[] shuffle = solution.shuffle();
        for (int i = 0; i < 100; i++) {
            for (int n : shuffle) {
                System.out.print(n + " ");
            }
            System.out.println();
        }


    }

}
