package myanswer.array.medium;

/**
 * @FileName: No845.java
 * @Description: No845.java类说明
 * @Author: camille
 * @Date: 2021/2/27 13:50
 */
public class No845 {

    // 暴力解法
    public int longestMountain(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i, right = i;
            while (left - 1 >= 0 && arr[left - 1] < arr[left]) {
                left--;
            }
            while (right + 1 <= arr.length - 1 && arr[right + 1] < arr[right]) {
                right++;
            }
            if (right != i && left != i) {
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

    // 先统计满足(right != i && left != i)条件的元素
    public int longestMountain1(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int left = i - 1, right = i + 1;
            if (arr[left] < arr[i] && arr[right] < arr[i]) {
                while (left >= 0 && arr[left] < arr[left + 1]) {
                    left--;
                }
                while (right<= arr.length - 1 && arr[right] < arr[right + 1]) {
                    right++;
                }
                res = Math.max(res, right - left + 1);
            }
        }
        return res;
    }

}
