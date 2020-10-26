package myanswer.array.medium;

import java.util.Arrays;

/**
 * @FileName: No16.java
 * @Description: 最接近的三数之和
 * @Author: camille
 * @Date: 2020/10/25 16:05
 */
public class No16 {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int s = i + 1;
            int e = n - 1;
            while (s < e) {
                int sum = nums[i] + nums[s] + nums[e];
                if (sum > target) {
                    e--;
                } else if (sum < target) {
                    s++;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No16 no16 = new No16();
        int[] nums = new int[]{-1,2,1,-4};
        int ans = no16.threeSumClosest(nums, 1);
        System.out.println(ans);
    }

}
