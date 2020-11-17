package myanswer.sort.medium;

import java.util.Arrays;

/**
 * @FileName: No324.java
 * @Description: 摆动排序2
 * @Author: admin
 * @Date: 2020/11/16 9:46
 */
public class No324 {

    public void wiggleSort(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        Arrays.sort(nums);
        int start1 = (nums.length - 1) / 2;
        int start2 = nums.length - 1;
        while (index < nums.length) {
            res[index] = nums[start1--];
            if (index + 1 < nums.length) {
                res[index + 1] = nums[start2--];
            }
            index = index + 2;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 3, 1};
        No324 no324 = new No324();
        no324.wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
