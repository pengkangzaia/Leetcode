package weeklytest;

import java.util.Stack;

/**
 * @author 彭康
 * @create 2021-08-08 11:48
 **/
public class No5840 {

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        if (sb.length() == 0) {
            return 0;
        }
        String newString = sb.reverse().toString();
        int len = (newString.length() / 2) % 2 == 0 ? newString.length() / 4 : (newString.length() / 2) / 2 + 1;
        return len;
    }

    public static void main(String[] args) {
        String s = "]]]][[][[][[[]]][[]][[[[][]]][[]]]]]][]][[][][[]][][[]]]][[[[[[[";
        No5840 no5840 = new No5840();
        int ans = no5840.minSwaps(s);
        System.out.println(ans);
    }


}
