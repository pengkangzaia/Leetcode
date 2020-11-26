package myanswer.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @FileName: No18.java
 * @Description: 四数之和
 * @Author: camille
 * @Date: 2020/11/25 20:21
 */
public class No18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 20:20开始
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= n -3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        // 去重，到当前的l和l的下一个位置不相等
                        while (l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r-1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        No18 no18 = new No18();
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> ans = no18.fourSum1(nums, 0);
        System.out.println(ans);
        System.out.println(no18.fourSum(nums, 0));
    }


}
