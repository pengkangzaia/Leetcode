package myanswer.array.medium;

import java.util.*;

public class No15 {

    private List<List<Integer>> res = new ArrayList<>();
    private HashSet<List<Integer>> set = new HashSet<>();

    // 三数之和
    // 固定一位数，求剩下的数的两数之和
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            twoSum(nums, i);
        }
        for (List<Integer> list : set) {
            res.add(list);
        }
        return res;
    }

    private void twoSum(int[] nums, int index) {
        int target = -nums[index];
        // 数组元素值，数组下标
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                if (map.containsKey(target - nums[i])) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[i]);
                    list.add(target - nums[i]);
                    Collections.sort(list);
                    set.add(list);
                    // res.add(list);
                }
                map.put(nums[i], i);
            }
        }

    }

    public List<List<Integer>> threeSumAns(int[] nums) {
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.addAll(set);
                return res;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    Collections.sort(list);
                    set.add(list);
                    //res.add(list);
                    L++;
                    R--;
                } else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        res.addAll(set);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 0, 2, 2};
        No15 no15 = new No15();
        List<List<Integer>> ans = no15.threeSum3(nums);
        /*for (List<Integer> list : ans) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }*/
        System.out.println(ans);
    }


    public List<List<Integer>> threeSum3(int[] nums) {
        // 19:55开始
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    // 需要跳出循环
                    // 需要去重
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    // 需要不同的数字
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }




}
