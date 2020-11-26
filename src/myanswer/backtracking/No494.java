package myanswer.backtracking;

/**
 * @FileName: No494.java
 * @Description: 目标和
 * @Author: camille
 * @Date: 2020/11/22 10:14
 */
public class No494 {

    // 这里记录的是回溯的解法，还有一个dp的解法，稍后些 todo

    private int res = 0;

    public int findTargetSumWays(int[] nums, int s) {
        findSum(nums, 0, s, 0);
        return res;
    }

    private void findSum(int[] nums, int currSum, int target, int currIndex) {
        if (currIndex == nums.length) {
            if (currSum == target) {
                res++;
            }
            return;
        }
        for (int i = 1; i >= -1; i = i - 2) {
            currSum = currSum + (i * nums[currIndex]);
            findSum(nums, currSum, target, currIndex + 1);
        }
        /*findSum(nums, currSum + nums[currIndex], target, currIndex + 1);
        findSum(nums, currSum - nums[currIndex], target, currIndex + 1);*/
    }

    public static void main(String[] args) {
        No494 no494 = new No494();
        int[] nums = {1,1,1,1,1};
        int ans = no494.findTargetSumWays(nums, 3);
        System.out.println(ans);
        String s = "AB12";
        String lowerCase = s.toLowerCase();
        System.out.println(lowerCase);
        // substring方法string是小写的
        String substring = s.substring(1, s.length());
        System.out.println(substring);
    }

}
