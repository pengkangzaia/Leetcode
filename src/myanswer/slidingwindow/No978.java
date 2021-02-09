package myanswer.slidingwindow;

/**
 * @FileName: No978.java
 * @Description: 最长湍流子数组
 * @Author: admin
 * @Date: 2021/2/9 10:14
 */
public class No978 {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 1, left = 0, right = 0;
        while (right < n - 1) {
            if (left == right) {
                if (arr[left] == arr[left + 1]) {
                    left++;
                    right++;
                } else {
                    right++;
                }
            } else {
                if (arr[right - 1] < arr[right] && arr[right + 1] > arr[right]) {
                    right++;
                } else if (arr[right - 1] > arr[right] && arr[right + 1] < arr[right]) {
                    right++;
                } else {
                    left = right;
                }
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

}
