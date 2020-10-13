package myanswer.dynamicprogramming;

/**
 * @FileName: No198_2.java
 * @Description: 打家劫舍2刷
 * @Author: admin
 * @Date: 2020/10/13 11:40
 */
public class No198_2 {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
     * 一夜之内能够偷窃到的最高金额。
     *
     */
    public int rob(int[] nums) {
        // 计算最大值
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            // 要么选间隔的一家+当前这家，要么对当前这家不进去
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        No198_2 no198_2 = new No198_2();
        int rob = no198_2.rob(new int[]{1, 2});
        System.out.println(rob);
    }

}
