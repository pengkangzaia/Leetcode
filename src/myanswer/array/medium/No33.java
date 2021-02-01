package myanswer.array.medium;

public class No33 {

    public int search(int[] nums, int target) {
        // 先找到最小值所在位置
        // 然后根据最小值分割的两个数组，二分查找target
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int middle = 0; // 有一种情况：这个数组是单调递增的。最小值就是第0位
        while (nums[left] > nums[right]) {
            if (right - left == 1) {
                middle = right;
                break;
            }
            middle = (right + left) / 2;
            if (nums[middle] > nums[left]) {
                left = middle;
            } else if (nums[middle] < nums[right]) {
                right = middle;
            }
        }

        // 比较最小值和target
        if (nums[middle] == target) {
            return middle;
        } else if (middle == 0) {
            // 整个数组是一直单调递增的情况
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (nums[middle] < target && target <= nums[nums.length - 1]) {
            // 在右边
            return binarySearch(nums, middle, nums.length - 1, target);
        } else if (nums[0] <= target && target <= nums[middle - 1]) {
            // 在左边
            return binarySearch(nums, 0, middle - 1, target);
        } else {
            return -1;
        }
    }

    private int binarySearch(int[] nums, int l, int r, int t) {
        int m = (l + r) / 2;
        while (l <= r) {
            if (nums[m] == t) {
                return m;
            } else if (nums[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            m = (l + r) / 2;
        }
        return -1;
    }

    // LeetCode的解法
    // 用mid分割成两个数组，每次只判断单调的那个数组。
    /*def search(self, nums: List[int], target: int) -> int:
            if not nums:
            return -1
    l, r = 0, len(nums) - 1
            while l <= r:
    mid = (l + r) // 2
            if nums[mid] == target:
            return mid
            if nums[0] <= nums[mid]:
            if nums[0] <= target < nums[mid]:
    r = mid - 1
            else:
    l = mid + 1
            else:
            if nums[mid] < target <= nums[len(nums) - 1]:
    l = mid + 1
            else:
    r = mid - 1
            return -1*/


    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[0] <= nums[m]) {
                if (target >= nums[0] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (target > nums[m] && target <= nums[nums.length - 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No33 no33 = new No33();
        int[] nums = {1, 2};
        int ans = no33.search1(nums, 2);
        System.out.println(ans);
    }

}
