package myanswer.math;

/**
 * @FileName: No29.java
 * @Description: 两数相除
 * @Author: camille
 * @Date: 2020/11/21 16:38
 */
public class No29 {

    public int divide(int dividend, int divisor) {

        // 特殊情况判断
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -1 * dividend;
            } else {
                // 除法溢出的话返回整数的最大值（这里是题目要求的）
                return Integer.MAX_VALUE;
            }
        }

        boolean negative = dividend < 0 ^ divisor < 0;
        // 整数溢出问题，考虑long类型
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((x >> i) >= y) {
                res += 1 << i;
                x = x - (y << i); // 减法的优先级高于 << 符号
            }
        }
        // while (x >= y) {
        //     x -= y;
        //     res++;
        // }
        return negative ? -1 * res : res;
    }

    public static void main(String[] args) {
        No29 no29 = new No29();
        for (int i = -20; i <= 40; i++) {
            for (int j = -30; j <= 50; j++) {
                if (j != 0) {
                    System.out.println("i=" + (i) + " j=" + (j)
                            + " 商=" + no29.divide(i, j)
                            + " 正确结果=" + ((i) / (j)));
                }
            }
        }
    }

}
