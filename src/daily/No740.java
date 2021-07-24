package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class No740 {

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int m = map.size();
        int[] dp = new int[m];
        int idx = 0;
        int lastKey = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            Integer value = map.get(key);
            int tempSum = key * value;
            if (idx == 0) {
                dp[idx] = tempSum;
            } else if (idx == 1) {
                if (key - 1 == lastKey) {
                    dp[idx] = Math.max(dp[idx - 1], tempSum);
                } else {
                    dp[idx] = dp[idx - 1] + tempSum;
                }
            } else {
                if (key - 1 == lastKey) {
                    dp[idx] = Math.max(dp[idx - 1], dp[idx - 2] + tempSum);
                } else {
                    dp[idx] = dp[idx - 1] + tempSum;
                }
            }
            lastKey = key;
            idx++;
        }
        return dp[m - 1];
    }


    public int deleteAndEarn1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = map.size();
        int[] array = new int[n];
        int idx = 0;
        for (Integer key : map.keySet()) {
            array[idx++] = key;
            map.put(key, key * map.get(key));
        }
        Arrays.sort(array);
        if (n == 1) {
            return map.get(array[0]);
        }
        if (n == 2) {
            return array[1] - array[0] == 1 ? Math.max(map.get(array[0]), map.get(array[1])) : map.get(array[0]) + map.get(array[1]);
        }
        int[] dp = new int[n];
        dp[0] = map.get(array[0]);
        dp[1] = array[1] - array[0] == 1 ? Math.max(map.get(array[0]), map.get(array[1])) : map.get(array[0]) + map.get(array[1]);
        for (int i = 2; i < n; i++) {
            // 如果两个数字之间相邻，则不能同时选择
            if (array[i] - array[i - 1] == 1) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + map.get(array[i]));
            } else {
                // 如果不相邻，直接加就完事了
                dp[i] = dp[i - 1] + map.get(array[i]);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        No740 no740 = new No740();
        int[] nums = {2, 2, 3, 2, 4, 4, 5, 4};
        int ans = no740.deleteAndEarn1(nums);
        System.out.println(ans);
    }


}
