package mock;

import java.util.Random;

/**
 * @FileName: Solution.java
 * @Description: Solution.java类说明
 * @Author: admin
 * @Date: 2021/3/6 13:09
 */
public class Solution {

    // 利用前缀和+二分搜索

    int[] num;
    int sum;

    public Solution(int[] w) {
        num = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            num[i + 1] = num[i] + w[i];
        }
        sum = num[w.length];
    }

    public int pickIndex() {
        Random r = new Random();
        int a = r.nextInt(sum);
        return binarySearch(num, a);
    }

    private int binarySearch(int[] num, int target) {
        int left = 0, right = num.length - 1;
        int memo = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > num[mid]) {
                memo = mid;
                left = mid + 1;
            } else if (target < num[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return memo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution solution = new Solution(nums);
        for (int i = 0; i < 12; i++) {
            int index = solution.pickIndex();
            System.out.println(index);
        }

    }


}
