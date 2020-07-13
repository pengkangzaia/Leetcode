package MyAnswer.array.easy;

import java.util.Arrays;

// 多数元素
public class No169 {

    // 排序法
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 摩尔计数法
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (candidate != nums[i]) {
                count--;
            } else {
                count++;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        No169 no169 = new No169();
        int ans = no169.majorityElement(nums);
        System.out.println(ans);
    }

}
