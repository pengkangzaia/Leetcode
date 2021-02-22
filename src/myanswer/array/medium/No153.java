package myanswer.array.medium;

/**
 * @FileName: No153.java
 * @Description: 寻找旋转排序数组中的最小值
 * @Author: admin
 * @Date: 2021/2/22 16:23
 */
public class No153 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // 考虑单调递增的情况
        if (nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) { // 小于等于
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) { // 与最右边的元素进行比较
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No153 no153 = new No153();
        int ans = no153.findMin(new int[]{1, 2, 3, 4, 5});
        System.out.println(ans);
    }

}
