package weeklytest;

/**
 * @FileName: No5691.java
 * @Description: No5691.java类说明
 * @Author: camille
 * @Date: 2021/2/28 12:07
 */
public class No5691 {

    public int minOperations(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > 6 * n || n > 6 * m) {
            return -1;
        }
        int sum1 = getSum(nums1);
        int sum2 = getSum(nums2);
        int[] freq1 = new int[6];
        int[] freq2 = new int[6];
        if (sum1 == sum2) {
            return 0;
        }
        for (int i = 0; i < nums1.length; i++) {
            freq1[nums1[i] - 1]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            freq2[nums2[i] - 1]++;
        }
        int res = 0;
        if (sum1 > sum2) {
            res += getOperation(sum1, sum2, freq1, freq2);
        } else {
            res += getOperation(sum2, sum1, freq2, freq1);
        }
        return res;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int getOperation(int sum1, int sum2, int[] freq1, int[] freq2) {
        int ans = 0;
        int diff = sum1 - sum2;
        for (int i = 5; i >= 0; i--) {
            while (freq1[i] > 0 && diff > 0) {
                diff -= i;
                freq1[i]--;
                ans++;
            }
            while (freq2[5 - i] > 0 && diff > 0) {
                diff -= i;
                freq2[5 - i]--;
                ans++;
            }
            if (diff <= 0) {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        No5691 no5691 = new No5691();
        // [3,3,2,4,2,6,2]
        //[6,2,6,6,1,1,4,6,4,6,2,5,4,2,1]
        int[] nums1 = {3, 3, 2, 4, 2, 6, 2};
        int[] nums2 = {6, 2, 6, 6, 1, 1, 4, 6, 4, 6, 2, 5, 4, 2, 1};
        int ans = no5691.minOperations(nums1, nums2);
        System.out.println(ans);
    }
}
