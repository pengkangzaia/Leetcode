package myanswer.sort.medium;

/**
 * @FileName: No162.java
 * @Description: 寻找峰值
 * @Author: admin
 * @Date: 2020/11/16 10:36
 */
public class No162 {

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // 递减子序列，峰值在左边
                // 当前mid可能为峰值
                end = mid;
            } else {
                // 递增子序列，峰值在右边
                // 当前mid值不可能为峰值
                start = mid + 1;
            }
        }
        System.out.println("start值为：" + start);
        System.out.println("end值为：" + end);
        // start和end值一定相等，为峰值
        return start;
    }

    public static void main(String[] args) {
        No162 no162 = new No162();
        int[] nums = {2,1,3279,209,13};
        int ans = no162.findPeakElement(nums);
        System.out.println(ans);
    }

}
