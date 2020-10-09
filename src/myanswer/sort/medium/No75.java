package myanswer.sort.medium;

import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No75 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 0, 0, 1, 1};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int p0 = 0;     //0的右边界
        int p2 = nums.length - 1;     //2的左边界
        int curr = p0;

        while (curr <= p2) {
            if (nums[curr] == 0) {
                nums[curr++] = nums[p0];
                nums[p0++] = 0;
            } else if (nums[curr] == 2) {
                nums[curr] = nums[p2];
                nums[p2--] = 2;
            } else curr++;
        }

    }


}
