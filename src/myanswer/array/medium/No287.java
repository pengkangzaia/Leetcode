package myanswer.array.medium;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No287 {
    public int findDuplicate(int[] nums) {
        /**
         * 思路：对数组进行排序（n*log（n））
         * 遍历数组，判读前一个数和后一个数是否相等
         */
        Arrays.sort(nums);
        int i = 0;
        while (nums[i]!=nums[i+1] && i+1<=nums.length-1){
            i++;
        }
        return nums[i];
    }


    public int findDuplicate1(int[] nums) {
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        // 每一个点都要检查
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (mid >= nums[i]) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                // mid点可能大于等于要求的值
                right = mid - 1;
                // mid点作为备选节点，继续迭代
                ans = mid;
            } else {
                // mid不可能是要求的值
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        No287 no287 = new No287();
        int[] nums = {1,3,3,3,4,4};
        int ans = no287.findDuplicate1(nums);
        System.out.println(ans);
    }

}
