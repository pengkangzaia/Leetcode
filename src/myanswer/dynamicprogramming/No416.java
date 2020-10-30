package myanswer.dynamicprogramming;

/**
 * @FileName: No416.java
 * @Description: 分割等和子集
 * @Author: admin
 * @Date: 2020/10/30 17:02
 */
public class No416 {

    // 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判：如果是奇数，就不符合要求
        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        // nums数组中的数字都可以作为被挑选的物品
        // 目标是使len个物品相加，等于target
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数（第一个物品）只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }

    public boolean canPartition1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target+1];
        // 初始化dp，第0个物品可以达到目标重量
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                }
                if (nums[i] < j) {
                    // 不选择nums[i]，就满足条件
                    // 或者选择nums[i]，前i-1个物品需要满足物品和为j-nums[i]
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][target];
    }

}
