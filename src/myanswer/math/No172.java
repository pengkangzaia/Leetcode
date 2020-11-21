package myanswer.math;

import java.math.BigInteger;

/**
 * @FileName: No172.java
 * @Description: 阶乘之后的零
 * @Author: camille
 * @Date: 2020/11/18 20:34
 */
public class No172 {

    // 参考链接:https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/

    public int trailingZeroes(int n) {
        // 2出现的频率比5低，所以统计5的个数就可以了
        // 5里面有1个5，10里面有2两个5，25里面有2个5
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

    // 阶乘测试
    public static void main(String[] args) {
        BigInteger ans = new BigInteger(String.valueOf(1));
        for (int i = 1; i < 100; i++) {
            ans = ans.multiply(new BigInteger(String.valueOf(i)));
            System.out.println("i=" + i + " 结果" + ans);
        }
    }

}
