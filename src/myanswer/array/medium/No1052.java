package myanswer.array.medium;

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
        while (right < customers.length) {

        }
    }


}
