package myanswer.math;

/**
 * @FileName: Gcd.java
 * @Description: 求最大公约数
 * @Author: admin
 * @Date: 2020/11/18 16:29
 */
public class Gcd {

    // 辗转相除法求最大公约数
    private int gcd(int a, int b) {
        // 一定是大数 除以 小数
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int temp = a % b;
            a = b; // a转为大数
            b = temp; // b转为余数
        }
        return a;
    }

    private int gcd1(int a, int b) {
        if (b != 0) {
            return gcd1(b, a % b);
        }
        return a;
    }

    public static void main(String[] args) {
        Gcd myGcd = new Gcd();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(myGcd.gcd(i, j) == myGcd.gcd1(i, j));
            }
        }
    }


}
