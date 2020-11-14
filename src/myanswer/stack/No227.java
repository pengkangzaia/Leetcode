package myanswer.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @FileName: No227.java
 * @Description: 基本计算器2
 * @Author: admin
 * @Date: 2020/11/14 13:51
 */
public class No227 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Deque<Character> symbol = new LinkedList<>();
        Deque<Integer> digit = new LinkedList<>();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int num = 0;
                while (i < chars.length && ((chars[i] >= '0' && chars[i] <= '9') || chars[i] == ' ') ) {
                    if (chars[i] >= '0' && chars[i] <= '9') {
                        num = (chars[i] - '0') + num * 10;
                    }
                    i++;
                }
                if (!symbol.isEmpty() && (symbol.peekLast() == '*' || symbol.peekLast() == '/')) {
                    Character pop = symbol.pollLast();
                    if (pop == '*') {
                        digit.addLast(digit.pollLast() * num);
                    } else {
                        digit.addLast(digit.pollLast() / num);
                    }
                } else{
                    digit.addLast(num);
                }
            }
            if (i < chars.length && (chars[i] == '*' || chars[i] == '/' || chars[i] == '+' || chars[i] == '-')) {
                symbol.addLast(chars[i]);
            }
            i++;
        }
        // 加减运算的顺序是从左往右
        while (!symbol.isEmpty()) {
            Integer num1 = digit.pollFirst();
            Integer num2 = digit.pollFirst();
            Character pop = symbol.pollFirst();
            if (pop == '+') {
                digit.addFirst(num1 + num2);
            } else {
                digit.addFirst(num1 - num2);
            }
        }
        return digit.peek();
    }

    public static void main(String[] args) {
        No227 no227 = new No227();
        int ans = no227.calculate("10+2*3 1");
        System.out.println(ans);
    }

}
