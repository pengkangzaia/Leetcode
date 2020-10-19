package myanswer.string;

import java.util.HashMap;
import java.util.Stack;

public class No20 {
    private HashMap<Character, Character> mappings;
    // Hash table that takes care of the mappings.

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public No20() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }
    public boolean isValid(String s) {
        //基于计算的方法行不通，不能判断括号的相对顺序
//        boolean f1 = true;
//        boolean f2 = true;
//        boolean f3 = true;
//        char[] chars = s.toCharArray();
//        for (int i = chars.length - 1; i >= 0; i--) {
//            if(chars[i]==')')   f1=false;
//            if(chars[i]=='(')   f1=!f1;
//            if(chars[i]=='}')   f2=false;
//            if(chars[i]=='{')   f2=!f2;
//            if(chars[i]==']')   f3=false;
//            if(chars[i]=='[')   f3=!f3;
//        }
//        return f1&&f2&&f3;
        //可以把左括号压栈，遇到匹配的右括号时，出栈；
        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {
                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();
                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }
        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //基于计数的不行，不能判断括号之间的相对位置。
        String s = "))))";
        No20 n =new No20();
        boolean valid = n.isValid(s);
        System.out.println(valid);
    }
}
