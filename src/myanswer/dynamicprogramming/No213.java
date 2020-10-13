package myanswer.dynamicprogramming;

/**
 * @FileName: No213.java
 * @Description: 打家劫舍2
 * @Author: admin
 * @Date: 2020/10/13 11:54
 */
public class No213 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，
     * 计算你在不触动警报装置的情况下，能够偷窃到的最高金额
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        // 去掉第一个元素
        int[] nums1 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i + 1];
        }
        // 去掉最后一个元素
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums2[i] = nums[i];
        }
        int res1 = getRob(nums1);
        int res2 = getRob(nums2);
        return Math.max(res1, res2);
    }

    public int getRob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No213 no213 = new No213();
        int rob = no213.rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }

}
