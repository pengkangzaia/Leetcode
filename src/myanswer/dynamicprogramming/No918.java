package myanswer.dynamicprogramming;

/**
 * @author 彭康
 * @create 2021-07-25 22:26
 **/
public class No918 {

    /**
     * 这个解法不对，有可能不仅仅取循环数组的第一个
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] copy = new int[n];
        for (int i = 0; i < n - 1; i++) {
            copy[i] = nums[i + 1];
        }
        copy[n - 1] = nums[0];
        return Math.max(maxSubarray(nums), maxSubarray(copy));
    }

    private int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) { // 之前的数起的是副作用
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }

    /**
     * 正确解法，分两种情况
     * 不需要跨越循环：最大子数组和
     * 需要跨越循环：求a[1]-a[i-2]之间的最小子数组和，整个数组之和减去最小子数组和就是采用了a[0]和a[n-1]的最大子数组和
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular1(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sum = nums[0];
        int[] dp = new int[n];

        dp[0] = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            if (dp[i - 1] > 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            maxValue = Math.max(maxValue, dp[i]);
        }

        dp[1] = nums[1];
        int minValue = nums[1];
        for (int i = 2; i < n - 1; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = nums[i] + dp[i - 1];
            } else {
                dp[i] = nums[i];
            }
            minValue = Math.min(minValue, dp[i]);
        }

        return Math.max(maxValue, sum - minValue);


    }


}
