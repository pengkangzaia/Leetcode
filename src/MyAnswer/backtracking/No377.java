package MyAnswer.backtracking;

/**
 * @FileName: No377.java
 * @Description: 组合总和4
 * @Author: admin
 * @Date: 2020/9/23 19:17
 */
public class No377 {
    // 回溯法，超时

    public int cnt = 0;

    /**
     * 结果集中结果可以重复（顺序不一样）返回所有组合的可能个数
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int sum = 0;
        traverse(nums, target, sum);
        return cnt;
    }

    public void traverse(int[] nums, int target, int sum) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            cnt++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            traverse(nums, target, sum);
            sum-=nums[i];
        }

    }

    public static void main(String[] args) {
        No377 no377 = new No377();
        int[] nums = {2,1,3};
        int ans = no377.combinationSum4(nums, 35);
        System.out.println(ans);
    }


}
