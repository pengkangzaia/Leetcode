package myanswer.array.medium;

import mock.MagicSquare;

/**
 * @FileName: No1052.java
 * @Description: 爱生气的书店老板
 * @Author: admin
 * @Date: 2021/2/23 10:33
 */
public class No1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // 10:28
        int sum = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += grumpy[i] == 0 ? customers[i] : 0;
        }
        int left = 0, right = 0;
        int res = sum;
        while (right < customers.length) {
            sum += grumpy[right] == 1 ? customers[right] : 0;
            right++;
            if (right - left > X) {
                sum -= grumpy[left] == 1 ? customers[left] : 0;
                left++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        No1052 no1052 = new No1052();
        int[] customers = {2,6,6,9};
        int[] grumpy = {0,0,1,1};
        int x = 1;
        int ans = no1052.maxSatisfied(customers, grumpy, x);
        System.out.println(ans);
    }


}
