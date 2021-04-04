package weeklytest;

/**
 * @FileName: No5724.java
 * @Description: No5724.java类说明
 * @Author: camille
 * @Date: 2021/4/4 10:55
 */
public class No5724 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int diffSum = 0;
        int[] freq = new int[100001];
        int[] diffArray = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            freq[nums1[i]]++;
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffArray[i] = diff;
            diffSum += diff;
        }

        int reduce = Integer.MAX_VALUE;
        for (int i = 0; i < nums2.length; i++) {
            int currKey = nums2[i];
            if (freq[currKey] != 0) {
                reduce = Math.min(reduce, -diffArray[i]);
            } else {
                // value为差值减小值
                int currValue;
                for (int m = currKey - 1, n = currKey + 1; m >= 0 || n < freq.length; m--, n++) {
                    // 只要找到就break
                    if (m >= 0) {
                        if (freq[m] != 0) {
                            currValue = currKey - m - diffArray[i];
                            reduce = Math.min(reduce, currValue);
                            break;
                        }
                    }
                    if (n < freq.length) {
                        if (freq[n] != 0) {
                            currValue = n - currKey - diffArray[i];
                            reduce = Math.min(reduce, currValue);
                            break;
                        }
                    }
                }
            }
        }
        return (diffSum + reduce) % (1000000007);
    }

    public static void main(String[] args) {
        int[] nums1 = {57, 42, 21, 28, 30, 25, 22, 12, 55, 3, 47, 18, 43, 29, 20, 44, 59, 9, 43, 7, 8, 5, 42, 53, 99, 34, 37, 88, 87, 62, 38, 68, 31, 3, 11, 61, 93, 34, 63, 27, 20, 48, 38, 5, 71, 100, 88, 54, 52, 15, 98, 59, 74, 26, 81, 38, 11, 44, 25, 69, 79, 81, 51, 85, 59, 84, 83, 99, 31, 47, 31, 23, 83, 70, 82, 79, 86, 31, 50, 17, 11, 100, 55, 15, 98, 11, 90, 16, 46, 89, 34, 33, 57, 53, 82, 34, 25, 70, 5, 1};
        int[] nums2 = {76, 3, 5, 29, 18, 53, 55, 79, 30, 33, 87, 3, 56, 93, 40, 80, 9, 91, 71, 38, 35, 78, 32, 58, 77, 41, 63, 5, 21, 67, 21, 84, 52, 80, 65, 38, 62, 99, 80, 13, 59, 94, 21, 61, 43, 82, 29, 97, 31, 24, 95, 52, 90, 92, 37, 26, 65, 89, 90, 32, 27, 3, 42, 47, 93, 25, 14, 5, 39, 85, 89, 7, 74, 38, 12, 46, 40, 25, 51, 2, 19, 8, 21, 62, 58, 29, 32, 77, 62, 9, 74, 98, 10, 55, 25, 62, 48, 48, 24, 21};
        No5724 no5724 = new No5724();
        int ans = no5724.minAbsoluteSumDiff(nums1, nums2);
        System.out.println(ans);
    }


}
