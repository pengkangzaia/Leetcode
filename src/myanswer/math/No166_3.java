package myanswer.math;

import java.util.HashMap;

/**
 * @FileName: No166_3.java
 * @Description: 分数到小数 自己实现版
 * @Author: admin
 * @Date: 2020/11/19 14:55
 */
public class No166_3 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder fraction = new StringBuilder();

        // trick2: 分子位0直接返回
        if (numerator == 0) {
            return "0";
        }

        // trick1: 处理符号位
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // 处理符号位之后按正整数处理
        // trick3: 按long类型来计算，int类型会发生溢出.反例：1/2147483648
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        fraction.append(numerator / denominator);
        int remainder = numerator % denominator;
        if (remainder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        HashMap<Integer, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                fraction.insert(map.get(remainder), "(");
                fraction.append(")");
                break;
            }
            // 把余数放进去，但凡出现之前出现过的余数，都表示开始循环了
            map.put(remainder, fraction.length());
            remainder = remainder * 10;
            fraction.append(remainder / denominator);
            remainder = remainder % denominator;
        }
        return fraction.toString();
    }

    public static void main(String[] args) {
        No166_3 no166_3 = new No166_3();
        String ans = no166_3.fractionToDecimal(-1, -2147483648);
        System.out.println(ans);
    }

}
