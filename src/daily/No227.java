package daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @FileName: No227.java
 * @Description: 基本计算器2
 * @Author: admin
 * @Date: 2021/3/11 9:52
 */
public class No227 {

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> operation = new ArrayDeque<>();
        int n = s.length();
        int idx = 0;
        char[] chars = s.toCharArray();
        while (idx < n) {
            char c = chars[idx];
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (idx + 1 < n && Character.isDigit(chars[idx + 1])) {
                    num = num * 10 + chars[idx + 1] - '0';
                    idx++;
                }
                stack.addLast(num);
            } else if (c == '+') {
                operation.addLast('+');
            } else if (c == '-') {
                operation.addLast('-');
            } else if (c == '*') {
                // 找到下一个数字
                while (idx < n && !Character.isDigit(chars[idx])) {
                    idx++;
                }
                int num = chars[idx] - '0';
                while (idx + 1 < n && Character.isDigit(chars[idx + 1])) {
                    num = num * 10 + chars[idx + 1] - '0';
                    idx++;
                }
                // 两个数字相乘直接压入栈中
                stack.addLast(stack.pollLast() * num);
            } else if (c == '/') {
                while (idx < n && !Character.isDigit(chars[idx])) {
                    idx++;
                }
                int num = chars[idx] - '0';
                while (idx + 1 < n && Character.isDigit(chars[idx + 1])) {
                    num = num * 10 + chars[idx + 1] - '0';
                    idx++;
                }
                stack.addLast(stack.pollLast() / num);
            }
            idx++;
        }

        // 加法和减法是从左往右计算的
        while (!operation.isEmpty()) {
            char oper = operation.pollFirst();
            switch (oper) {
                case '+': {
                    int num1 = stack.pollFirst();
                    int num2 = stack.pollFirst();
                    stack.push(num2 + num1);
                    break;
                }
                case '-': {
                    int num1 = stack.pollFirst();
                    int num2 = stack.pollFirst();
                    stack.push(num1 - num2);
                    break;
                }
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        No227 no227 = new No227();
        int calculate = no227.calculate("0-2147483647");
        System.out.println(calculate);
        System.out.println(no227.calculate("1-1+1"));
        System.out.println(no227.calculate("1+1-1"));
    }




}
