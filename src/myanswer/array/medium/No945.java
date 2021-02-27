package myanswer.array.medium;

import java.util.Arrays;

/**
 * @FileName: No945.java
 * @Description: No945.java类说明
 * @Author: camille
 * @Date: 2021/2/27 12:35
 */
public class No945 {

    public int minIncrementForUnique(int[] nums) {
        // 1,1,2,2,3,7
        // 1,2,3,4,5,7
        // 1+1+2+2=6
        Arrays.sort(nums);
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[i] <= nums[i - 1]) {
                nums[i]++;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No945 no945 = new No945();
        int ans = no945.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7});
        System.out.println(ans);
    }


}
