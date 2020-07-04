package MyAnswer.array.easy;

public class No53 {

    // 最大子序和
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0 && nums[i] > sum) {
                // nums[i] > sum而不是大于0，比如[-2,-1]
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        No53 no53 = new No53();
        int[] nums = {-2,-1,-3,-5,-10,-6};
        int ans = no53.maxSubArray(nums);
        System.out.println(ans);
    }

}
