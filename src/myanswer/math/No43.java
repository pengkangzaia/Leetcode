package myanswer.math;

import java.math.BigInteger;

/**
 * @FileName: No43.java
 * @Description: 字符串相乘
 * @Author: admin
 * @Date: 2020/10/17 21:18
 */
public class No43 {

    // 打注释的地方都需要注意

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        // 总共m-1+n-1+1位
        int[] res = new int[m + n];
        // 从后往前计算
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int n1 = chars1[i] - '0';
                int n2 = chars2[j] - '0';
                int sum = n1 * n2 + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                // 这里res[i+j]可以大于10，下一次计算会用res[i+j]计算sum（因为i和j是递减的）
                res[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        // 排除掉所有前缀为0的数字
        int idx = 0;
        while (idx < res.length && res[idx] == 0) {
            idx++;
        }
        for (int i = idx; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        /*BigInteger res = new BigInteger(String.valueOf(1));
        int n = 100;
        while (n > 0) {
            res = res.multiply(new BigInteger(String.valueOf(n)));
            n--;
        }
        System.out.println(res.toString());*/
        String num1 = "809432795739587349";
        String num2 = "3957392875982";
        No43 no43 = new No43();
        String ans = no43.multiply(num1, num2);
        System.out.println(ans);
    }

}
