package daily;

import java.util.Iterator;
import java.util.Set;
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


}
