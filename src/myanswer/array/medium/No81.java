package myanswer.array.medium;

/**
 * @FileName: No81.java
 * @Description: 搜索旋转排序数组 II
 * @Author: admin
 * @Date: 2021/2/3 21:51
 */
public class No81 {

    public static void main(String[] args) {
        No81 no81 = new No81();
        int[] nums = {2,5,6,0,0,1,2};
        int target = 2;
        boolean ans = no81.search(nums, target);
        System.out.println(ans);
    }

    // 参考英文版题解
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) return true;
            // 左半部分是有序的
            if (nums[left] < nums[mid]) {
                // 如果target不在有序部分范围内
                if (target < nums[left] || target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[left] > nums[mid]) { // 右半部分是有序的
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 此时nums[left]等于nums[mid]，nums[mid]不能于target，所以left不等于target
                // 排除重复项。
                left++;
            }
        }
        return false;
    }


}
