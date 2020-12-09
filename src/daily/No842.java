package daily;

import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No842.java
 * @Description: 将数组拆分为斐波那契序列
 * @Author: admin
 * @Date: 2020/12/8 14:08
 */
public class No842 {

    public static void main(String[] args) {
        String input = "1011";
        List<Integer> res = splitIntoFibonacci(input);
        System.out.println(res);
    }

    public static List<Integer> splitIntoFibonacci(String s) {
        if (s == null || s.length() == 0) {
            return new LinkedList<>();
        }
        List<Integer> res = new LinkedList<>();
        boolean backtracking = backtracking(res, s.toCharArray(), 0);
        System.out.println(backtracking);
        return res;
    }

    public static boolean backtracking(List<Integer> res, char[] chars, int index) {
        if (index == chars.length && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < chars.length; i++) {
            // 如果十位以上数字以 0 开头，则不行。
            if (chars[index] == '0' && i > index) {
                return false;
            }
            long currNum = charsToDigit(chars, index, i + 1);
            // 当前数字如果大于int最大值，直接退出
            if (currNum > Integer.MAX_VALUE) {
                return false;
            }
            if (res.size() < 2 || res.get(res.size() - 1) + res.get(res.size() - 2) == currNum) {
                res.add((int) currNum);
                if (backtracking(res, chars, i + 1)) {
                    return true;
                }
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    private static long charsToDigit(char[] chars, int s, int e) {
        long dig = 0;
        for (int i = s; i < e; i++) {
            dig *= 10;
            dig += chars[i] - '0';
        }
        return dig;
    }

}
