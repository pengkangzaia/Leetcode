package myanswer.math;

/**
 * @FileName: No191.java
 * @Description: 位1的个数
 * @Author: admin
 * @Date: 2020/11/19 9:44
 */
public class No191 {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            // 如果第i位不为0
            if ((n & (1 << i)) != 0) {
                res++;
            }
        }
        return res;
    }


}
