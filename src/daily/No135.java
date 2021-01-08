package daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: No135.java
 * @Description: 分发糖果
 * @Author: admin
 * @Date: 2020/12/24 9:41
 */
public class No135 {

    public int candy(int[] ratings) {
        // 1 0 2 -> 5 (2, 1, 2)
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        // 谷点的索引集合
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(ratings.length - 1);
        for (int i = 1; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i-1] && ratings[i] < ratings[i+1]) {
                set.add(i);
            }
        }
        for (Integer index : set) {
            int prevIdx = index;
            int leftIdx = index - 1, rightIdx = index + 1;
            while (leftIdx >= 0) {
                if (ratings[leftIdx] > ratings[prevIdx]) {
                    count[leftIdx] = Math.max(count[leftIdx], count[prevIdx] + 1);
                    leftIdx--;
                    prevIdx--;
                } else if (ratings[leftIdx] == ratings[prevIdx]) {
                    count[leftIdx] = Math.min(count[leftIdx], count[prevIdx]);
                    leftIdx--;
                    prevIdx--;
                } else {
                    break;
                }
            }
            prevIdx = index;
            while (rightIdx < n) {
                if (ratings[rightIdx] > ratings[prevIdx]) {
                    count[rightIdx] = Math.max(count[rightIdx], count[prevIdx] + 1);
                    rightIdx++;
                    prevIdx++;
                } else if (ratings[rightIdx] == ratings[prevIdx]) {
                    count[rightIdx] = Math.min(count[rightIdx], count[prevIdx]);
                    rightIdx++;
                    prevIdx++;
                } else {
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res += count[i];
        }
        return res;
    }

    public static void main(String[] args) {
        No135 no135 = new No135();
        int[] nums = {1, 2, 2};
        int ans = no135.candy1(nums);
        System.out.println(ans);
    }

    // leetcode大佬解法
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) {
                count[i] = count[i-1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                count[i] = Math.max(count[i], count[i+1] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res += count[i];
        }
        return res;
    }

}
