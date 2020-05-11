package MyAnswer.stack;

import java.util.Stack;

public class No9 {

    public static void main(String[] args) {

        System.out.println(isPalindrome2(-12121));
        System.out.println(isPalindrome2(12121));
        System.out.println(isPalindrome2(1121));
        System.out.println(isPalindrome2(121));
    }


    public static boolean isPalindrome(int x) {
        // 输入一个数x，判断这个数是否是回文数
        // 1.把数转化为字符串
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        // 2.把字符串压入栈中
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            stack.push(c);
        }
        // 3.栈中元素出栈，和字符串进行比较
        int i = 0;
        while (!stack.empty()) {
            Character top = stack.pop();
            if (top != chars[i]) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int cur = 0;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num = num / 10;
        }
        return cur == x;
    }


}
