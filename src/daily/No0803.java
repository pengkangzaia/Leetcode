package daily;

public class No0803 {

    // https://leetcode-cn.com/problems/magic-index-lcci/
    // 魔术索引
    // 这题需要考虑的是重复元素的情况
    public int findMagicIndex(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            // int mid = (i+j)/ 2;
            int mid = (j - i) / 2 + i;
            int temp = mid;
            if (nums[mid] > mid) {
                while (temp <= nums.length -1 && nums[temp] == nums[mid]) {
                    if (nums[temp] == temp) {
                        return temp;
                    }
                    temp++;
                }
                j = mid - 1;
            } else if (nums[mid] < mid) {
                // [0,0,2]的情况
                while (temp >= 0 && nums[temp] == nums[mid]) {
                    if (nums[temp] == temp) {
                        return temp;
                    }
                    temp--;
                }
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        No0803 no0803 = new No0803();
        int[] nums = {0, 0, 2};
        int ans = no0803.findMagicIndex(nums);
        System.out.println(ans);
    }


}
