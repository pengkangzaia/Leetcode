package myanswer.array.easy;

/**
 * @FileName: No724.java
 * @Description: No724.java类说明
 * @Author: admin
 * @Date: 2021/1/28 9:46
 */
public class No724 {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n - 1;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                left[i] = nums[i];
            } else {
                left[i] = left[i - 1] + nums[i];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == n - 1) {
                right[i] = nums[i];
            } else {
                right[i] = right[i + 1] + nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No724 no724 = new No724();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int ans = no724.pivotIndex(nums);
        System.out.println(ans);
    }


}
