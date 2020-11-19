package myanswer.math;

/**
 * @FileName: No326.java
 * @Description: 3的幂
 * @Author: camille
 * @Date: 2020/10/10 22:52
 */
public class No326 {

    public boolean isPowerOfThree(int n) {
        // 1也可以！3的零次方
        if (n == 1) {
            return true;
        }
        if (n < 1 || n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }

    // 算数解法
    public boolean isPowerOfThree1(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    // 迭代解法
    public boolean isPowerOfThree2(int n) {
        int a = 1;
        int b;
        while (a < n) {
            b = a * 3;
            if (b / 3 != a) {
                return false;
            } else {
                a = b;
            }
        }
        return a == n;
    }

    public static void main(String[] args) {
        No326 no326 = new No326();
        /*for (int i = 1000; i >= 0; i--) {
            System.out.println(i + " " + no326.isPowerOfThree2(i) + " " + no326.isPowerOfThree1(i));
        }*/
        boolean powerOfThree2 = no326.isPowerOfThree1(2147483647);
        System.out.println(powerOfThree2);
    }
}
