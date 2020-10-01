package MyAnswer.array.easy;

/**
 * @FileName: No35.java
 * @Description: 搜索插入位置
 * @Author: kang.peng
 * @Date: 2020/10/1 15:03
 */
public class No35 {

    // 二分搜索

    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else if (nums[mid] > target) {
                j = mid - 1;
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        No35 no35 = new No35();
        int res = no35.searchInsert(new int[]{1, 3, 5, 6}, 0);
        System.out.println(res);
    }

}
