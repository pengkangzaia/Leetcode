package myanswer.math;

/**
 * @FileName: No371.java
 * @Description: 两整数之和
 * @Author: camille
 * @Date: 2020/11/21 19:33
 */
public class No371 {

    public int getSum(int a, int b) {
        // 如果两个负数相加并且溢出了，会截断后32bit位，结果返回正数
        int carry = 0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i <= 31; i++) {
            int currBitOfA = a & (1 << i);
            int currBitOfB = b & (1 << i);
            sum = currBitOfA ^ currBitOfB;
            res += sum + carry;
            carry = (currBitOfA & currBitOfB) << 1; // 进位位左移一位
        }
        return res;
    }

    public static void main(String[] args) {
        No371 no371 = new No371();
        int sum = no371.getSum(-1, 1);
        System.out.println(sum);
    }

}
