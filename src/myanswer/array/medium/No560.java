package myanswer.array.medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @FileName: No560.java
 * @Description: 和为k的子数组
 * @Author: admin
 * @Date: 2020/10/30 15:33
 */
public class No560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;

        //        int count = 0;
        //        for (int start = 0; start < nums.length; ++start) {
        //            int sum = 0;
        //            for (int end = start; end >= 0; --end) {
        //                sum += nums[end];
        //                if (sum == k) {
        //                    count++;
        //                }
        //            }
        //        }
        //        return count;
        //
        //作者：LeetCode-Solution
        //链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    }

    public static void main(String[] args) {
        No560 no560 = new No560();
        int[] nums = {1, -1, 0,1,-1};
        int ans = no560.subarraySum(nums, 0);
        System.out.println(ans);
    }

}
