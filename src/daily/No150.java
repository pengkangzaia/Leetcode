package daily;

import java.util.Stack;

/**
 * @FileName: No150.java
 * @Description: No150.java类说明
 * @Author: camille
 * @Date: 2021/3/20 9:27
 */
public class No150 {


    public int evalRPN(String[] tokens) {
        int res = -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 + num2);
            } else if (s.equals("-")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (s.equals("*")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1 * num2);
            } else if (s.equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }


    public static void main(String[] args) {
        No150 no150 = new No150();
        String[] tokens = {"2", "1", "+", "3", "*"};
        int ans = no150.evalRPN(tokens);
        System.out.println(ans);
    }


}
