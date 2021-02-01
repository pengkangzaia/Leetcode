package myanswer.array.medium;

public class No34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        int l = 0;
        int r = nums.length - 1;
        // 计算 mid 时需要防止溢出，
        // 代码中left + (right - left) / 2 就和
        // (left + right) / 2 的结果相同，
        // 但是有效防止了 left 和 right 太大直接相加导致溢出。
        int m = (l + r) / 2;
        while (l <= r) {
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                break;
            }
            m = (l + r) / 2;
        }
        if (nums[m] != target) {
            return res;
        } else {
            l = m;
            r = m;
            // 判断索引是否越界
            while (l >= 0 && nums[l] == target) {
                l--;
            }
            while (r <= nums.length - 1 && nums[r] == target) {
                r++;
            }
            res[0] = l + 1;
            res[1] = r - 1;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,5,5,6,6,8};
        No34 no34 = new No34();
        int[] ans = no34.searchRange(nums, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
