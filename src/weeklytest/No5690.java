package weeklytest;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @FileName: No5690.java
 * @Description: No5690.java类说明
 * @Author: camille
 * @Date: 2021/2/28 10:43
 */
public class No5690 {

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        // 先计算配料的所有可能性
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        dfs(set, toppingCosts, 0, toppingCosts.length - 1);
        int[] ans = new int[set.size() * baseCosts.length];
        Integer[] temp = set.toArray(new Integer[set.size()]);
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < baseCosts.length; j++) {
                ans[i * baseCosts.length + j] = baseCosts[j] + temp[i];
            }
        }
        Arrays.sort(ans);
        if (ans[0] >= target) {
            return ans[0];
        }
        for (int i = 0; i < ans.length - 1; i++) {
            if (ans[i + 1] == target) {
                return target;
            } else if (ans[i + 1] > target) {
                return Math.min(Math.abs(ans[i] - target), Math.abs(ans[i + 1] - target));
            }
        }
        return ans[ans.length - 1];
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return target;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left - 1];
    }

    private void dfs(TreeSet<Integer> set, int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        dfs(set, nums, start + 1, end);
        Integer[] arr = new Integer[set.size()];
        Integer[] integers = set.toArray(arr);
        for (Integer integer : integers) {
            set.add(nums[start] + integer);
            set.add(2 * nums[start] + integer);
        }

    }

    public static void main(String[] args) {
        No5690 no5690 = new No5690();
        int ans = no5690.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18);
        System.out.println(ans);
    }

}
