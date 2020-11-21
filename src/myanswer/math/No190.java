package myanswer.math;

/**
 * @FileName: No190.java
 * @Description: 颠倒二进制位
 * @Author: camille
 * @Date: 2020/11/18 21:21
 */
public class No190 {

    // 有符号右移>>
    // 有符号右移就是右移之后，左边的补上符号位，正数补0，负数补1

    // 无符号右移>>>
    // 无符号右移就是右移之后，无论该数为正还是为负，右移之后左边都是补上0
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        // n可能没移动32位就已经等于0了，所以不能用n == 0作为循环结束的条件
        int count = 0;
        while (count < 32) {
            if ((n & 1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            n = n >>> 1;
            count++;
        }
        String s = sb.toString();
        char[] chars = s.toCharArray();
        System.out.println(sb.toString());
        int res = chars[31] - '0';
        for (int i = 30; i >= 0; i--) {
            res = res << 1;
            res = res ^ (chars[i] - '0');
        }
        return res;
    }

    public static void main(String[] args) {
        No190 no190 = new No190();
        int ans = no190.reverseBits(10);
        System.out.println(ans);
        System.out.println(no190.reverseBits1(10));
    }

    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            int temp = 1 << i;
            // (n & temp) == 1不一定成立，因为temp值会变的。
            // 但是如果n的当前二进制位为0，则一定为0
            if ((n & (temp)) != 0) {
                res = res ^ (1 << (31 - i));
            }
            // res ^= (n & (1 << i)) != 0 ? 1 << (31 - i) : 0;
        }
        return res;
    }


}
