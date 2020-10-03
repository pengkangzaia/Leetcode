package myanswer.array.easy;

import java.util.Arrays;

public class No581 {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int i = 0;
        int j = len - 1;
        while (i < j) {
            if (nums[i] == temp[i]) {
                i++;
            } else {
                break;
            }
        }
        while (i < j) {
            if (nums[j] == temp[j]) {
                j--;
            } else {
                break;
            }
        }
        return j - i > 0 ? (j - i) + 1 : (j - i);
    }

    public static void main(String[] args) {
        No581 no581 = new No581();
        int[] nums = {3, 4, 5, 6, 4};
        int ans = no581.findUnsortedSubarray(nums);
        System.out.println(ans);
    }


}
