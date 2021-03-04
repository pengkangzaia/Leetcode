package bishi.xiecheng;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @FileName: No1.java
 * @Description: 计算器
 * @Author: admin
 * @Date: 2021/3/4 21:28
 */
public class No1 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String input;
        while (cin.hasNext()) {
            input = cin.nextLine();
            String output = calculate(input);
            System.out.println(output);
        }
    }

    public static String calculate(String input) {
        char[] chars = input.toCharArray();
        Deque<String> stack = new LinkedList<>();
        int idx = chars.length - 1;
        while (idx >= 0) {
            if (Character.isDigit(chars[idx])) {
                int right = idx, left = idx;
                while (left >= 0 && Character.isDigit(chars[left])) {
                    left--;
                }
                String num = getNum(chars, left + 1, right);
                stack.push(num);
                idx = left;
            } else if (chars[idx] == ')') {
                stack.push(chars[idx] + "");
                idx--;
            } else if (chars[idx] == '(') {
                idx--;
            } else if (chars[idx] == '+') {
                int currSum = 0;
                while (!stack.isEmpty() && !")".equals(stack.peek())) {
                    currSum += Integer.parseInt(stack.pop());
                }
                if (!stack.isEmpty() && ")".equals(stack.peek())) {
                    stack.pop();
                }
                stack.push(String.valueOf(currSum));
                idx--;
            } else if (chars[idx] == '-') {
                int currMin = 0;
                String num1 = stack.pop();
                while (stack.size() >= 2 && !")".equals(stack.peek())) {
                    currMin += Integer.parseInt(stack.pop());
                }
                if (!stack.isEmpty() && ")".equals(stack.peek())) {
                    stack.pop();
                }
                stack.push(String.valueOf(Integer.parseInt(num1) - currMin));
                idx--;

            } else if (chars[idx] == '*') {
                int currMul = 1;
                while (stack.size() >= 2 && !")".equals(stack.peek())) {
                    currMul *= Integer.parseInt(stack.pop());
                }
                if (!stack.isEmpty() && ")".equals(stack.peek())) {
                    stack.pop();
                }
                stack.push(String.valueOf(currMul));
                idx--;
            } else if (chars[idx] == ' ') {
                idx--;
            }
        }
        return stack.pop();
    }

    private static String getNum(char[] chars, int left, int right) {
        StringBuilder sb = new StringBuilder();
        for (int i = left; i <= right; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }



}
