package sword2offer;

public class Question53_1 {

    // 统计一个数字在排序数组中出现的次数。
    public int search(int[] nums, int target) {
        // 二分搜索
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        int mid = -1;
        while (i <= j) {
            mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid;
            } else if (nums[mid] > target) {
                j = mid;
            } else {
                break;
            }
        }
        if (nums[mid] == target) {
            i = mid - 1;
            j = mid + 1;
            while (nums[i] == target) {
                i--;
                count++;
            }
            while (nums[j] == target) {
                j++;
                count++;
            }
        }
        return nums[mid] == target ? count + 1 : 0;
    }

}
