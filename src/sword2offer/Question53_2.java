package sword2offer;

public class Question53_2 {

    public int missingNumber(int[] nums) {
        if (nums.length == 1) {
            return nums.length - nums[0];
        }
        int ans;
        if (nums[0] == 0) {
            ans = nums.length;
        } else {
            ans = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                ans = nums[i - 1] + 1;
                break;
            }
        }
        return ans;
    }

    public static int missingNumberBinarySearch(int[] nums) {
        int n = nums.length - 1;
        int m = (n) / 2;
        while (nums[m] == m) {
            m = (m + n) / 2;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {0,1};
        int ans = missingNumberBinarySearch(nums);
        System.out.println(ans);
    }


}
