package myanswer.stack;

import java.util.Stack;

/**
 * @FileName: No150.java
 * @Description: 逆波兰表示式求值
 * @Author: admin
 * @Date: 2020/11/14 15:43
 */
public class No150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (tokens[i]) {
                    case "+":
                        stack.push(num2 + num1);
                        break;
                    case "-":
                        stack.push(num2 - num1);
                        break;
                    case "*":
                        stack.push(num2 * num1);
                        break;
                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }

    public static void main(String[] args) {
        String[] strings = {"2", "1", "+", "3", "*"};
        No150 no150 = new No150();
        int ans = no150.evalRPN(strings);
        System.out.println(ans);
    }

}
