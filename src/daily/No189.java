package daily;

import java.util.Arrays;

/**
 * @FileName: No189.java
 * @Description: 旋转数组
 * @Author: admin
 * @Date: 2021/1/8 14:03
 */
public class No189 {


    public void rotate(int[] nums, int k) {
        // 反转
        k = k % nums.length;
        flip(nums, 0, nums.length - 1);
        flip(nums, 0, k - 1);
        flip(nums, k, nums.length - 1);
    }

    private void flip(int[] nums, int left, int right) {
        int temp = 0;
        while (left <= right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // 超级管理员怎么配置呢？
    //


    public static void main(String[] args) {
        No189 no189 = new No189();
        int[] nums = {-1,-100,3,99};
        int k = 2;
        no189.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

}
