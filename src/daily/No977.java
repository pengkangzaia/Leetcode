package daily;

import java.util.Arrays;

/**
 * @FileName: No977.java
 * @Description: 有序数组的平方
 * @Author: camille
 * @Date: 2020/10/16 21:26
 */
public class No977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 21:31
    public int[] sortedSquares1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * nums[i];
        }
        // 双指针解法
        int[] res = new int[n];
        int i = 0;
        int j = n - 1;
        int k = n - 1;
        while (i <= j) {
            if (nums[i] <= nums[j]) {
                res[k--] = nums[j--];
            } else {
                res[k--] = nums[i++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No977 no977 = new No977();
        int[] ints = no977.sortedSquares(new int[]{-4,-1,0,3,10});
        int[] ints1 = no977.sortedSquares1(new int[]{-4,-1,0,3,10});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < ints1.length; i++) {
            System.out.print(ints1[i] + " ");
        }
    }

}
