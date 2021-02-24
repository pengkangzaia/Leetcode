package myanswer.array.easy;

/**
 * @FileName: No1013.java
 * @Description: 将数组分成和相等的三个部分
 * @Author: admin
 * @Date: 2021/2/23 13:52
 */
public class No1013 {

    // 可优化为前缀和+后缀和+求数组和的三分之一

    public boolean canThreePartsEqualSum(int[] arr) {
        // 前缀和+遍历
        int n = arr.length;
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1] + arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] - arr[i] && arr[i] == arr[n - 1] - arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        No1013 no1013 = new No1013();
        int[] arr = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        boolean b = no1013.canThreePartsEqualSum(arr);
        System.out.println(b);
    }


}
