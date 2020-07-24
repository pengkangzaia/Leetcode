package test;

import java.math.BigInteger;

public class MulTest {

    // 1*2*3*..*100
    // 大数相乘
    public static void main(String[] args) {
        BigInteger tem = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= 100; i++) {
            tem = tem.multiply(BigInteger.valueOf(i));
        }
        System.out.println(tem);
    }

    /*public char[] mul(char[] a, char[] b) {

        char[] result = new char[a.length + b.length];
        BigInteger
    }*/


}
