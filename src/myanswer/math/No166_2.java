package myanswer.math;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * @FileName: No166_2.java
 * @Description: 分数到小数（自己尝试实现版）
 * @Author: camille
 * @Date: 2020/11/18 19:52
 */
public class No166_2 {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        // int可能会越界
        long x = Math.abs(Long.valueOf(numerator));
        long y = Math.abs(Long.valueOf(denominator));
        fraction.append(x / y);
        long reminder = x % y;
        if (reminder == 0) {
            return fraction.toString();
        }
        fraction.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (reminder != 0) {
            if (map.containsKey(reminder)) {
                fraction.insert(map.get(reminder), "(");
                fraction.append(")");
                break;
            }
            map.put(reminder, fraction.length());
            reminder = reminder * 10;
            fraction.append(String.valueOf(reminder / y));
            reminder = reminder % y;
        }
        return fraction.toString();

    }





}
