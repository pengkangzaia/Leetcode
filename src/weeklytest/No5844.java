package weeklytest;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author 彭康
 * @create 2021-08-15 11:17
 **/
public class No5844 {

    public int minNonZeroProduct(int p) {
        if (p == 1) {
            return 1;
        }
        // 注意bigInteger的用法
        return BigInteger.valueOf((1L << p) - 2).modPow(
                BigInteger.valueOf((1L << (p - 1)) - 1), BigInteger.valueOf(1000000007))
                .multiply(BigInteger.valueOf((1L << p) - 1)).mod(BigInteger.valueOf(1000000007)).intValue();
    }


    public static void main(String[] args) {
        No5844 no5844 = new No5844();
        for (int i = 1; i <= 60; i++) {
            int ans = no5844.minNonZeroProduct(i);
            System.out.println(i + "----" + ans);
        }
        String s = "age";


    }


}
