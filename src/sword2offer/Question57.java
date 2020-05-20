package sword2offer;

import java.util.HashMap;

public class Question57 {

    public int[] twoSum(int[] nums, int target) {
        // HashMap法：超时
        /*HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] ans = new int[2];
        int i = 0;
        while (i < nums.length) {
            if (hashMap.containsValue(target - nums[i])) {
                ans[0] = nums[i];
                ans[1] = target - nums[i];
                return ans;
            } else {
                hashMap.put(i, nums[i]);
                i++;
            }
        }
        return ans;*/

        // 双指针法
        int[] ans = new int[2];
        int i = 0;
        int j = nums.length - 1;
        int s;
        while (i < j) {
            s = nums[i] + nums[j];
            if (s < target) {
                i++;
            } else if (s > target) {
                j--;
            } else {
                ans[0] = nums[i];
                ans[1] = nums[j];
                return ans;
            }
        }
        return ans;
    }

}
