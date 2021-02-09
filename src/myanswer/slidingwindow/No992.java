package myanswer.slidingwindow;

/**
 * @FileName: No992.java
 * @Description: K 个不同整数的子数组
 * @Author: admin
 * @Date: 2021/2/9 10:41
 */
public class No992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        // 求恰好包含k个不同整数的区间个数 = 最多包含k个整数的区间个数 - 最多包含k-1个整数的区间个数
        return mostDistinct(A, K) - mostDistinct(A, K - 1);
    }

    private int mostDistinct(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        int[] freq = new int[len + 1];
        int left = 0, right = 0, count = 0;
        // 注意看这里的条件是 right < len
        while (right < len) {
            if (freq[nums[right]] == 0) {
                count++;
            }
            freq[nums[right]]++;
            right++;
            while (count > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left; // 左闭右开区间
        }
        return res;
    }


}
