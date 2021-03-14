package weeklytest;

/**
 * @FileName: No5704.java
 * @Description: 好子数组的最大分数
 * @Author: camille
 * @Date: 2021/3/14 12:12
 */
public class No5704 {

    // 等价于求矩形的最大值
    public int maximumScore(int[] nums, int k) {
        for (int i = k + 1; i < nums.length; ++i) {
            nums[i] = Math.min(nums[i - 1], nums[i]);
        }
        for (int i = k - 1; i >= 0; --i) {
            nums[i] = Math.min(nums[i], nums[i + 1]);
        }
        int res = 0;
        for (int minv = nums[k], l = k, r = k; minv >= 0; --minv) {
            while (l > 0 && nums[l - 1] >= minv) --l;
            while (r + 1 < nums.length && nums[r + 1] >= minv) ++r;
            res = Math.max(res, (r - l + 1) * minv);
        }
        return res;
    }

    // nums = [1,4,3,7,4,5], k = 3
    // nums = [5,5,4,5,4,1,1,1], k = 0

    public static void main(String[] args) {
        No5704 no5704 = new No5704();
        int[] nums = {1, 4, 3, 7, 4, 5};
        int ans = no5704.maximumScore(nums, 3);
        System.out.println(ans);
    }


}
