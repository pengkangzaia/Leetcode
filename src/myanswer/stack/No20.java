/*
 * Copyright: 2020 dingxiang-inc.com Inc. All rights reserved.
 */

package myanswer.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * @FileName: No20.java
 * @Description: 有效的括号
 * @Author: kang.peng
 * @Date: 2020/9/26 17:09
 */
public class No20 {

    private HashMap<Character,Character> hm;

    public No20() {
        this.hm = new HashMap<>();
        this.hm.put(')','(');
        this.hm.put('}','{');
        this.hm.put(']','[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.hm.containsKey(c)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != this.hm.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // 建一个Hashmap，表示括号之间的对应关系
        // 建一个栈，从左往右对字符串中每一个字符进行判断
        // 是key，push。是value，stack.pop == value ? continue : false
        if (s == null || s.length() == 0 || s.length() % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        int i = 0;
        // 不需要提前将第一个字符压进stack中，后面的循环会自己做
        // stack.push(s.charAt(i++));
        // stack.isEmpty()不能作为循环判断结束的条件，比如：{}[]((
        while(i < s.length()) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                stack.push(cur);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char pop = stack.pop();
                    if (map.get(pop) != cur) {
                        return false;
                    }
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        No20 no20 = new No20();
        boolean valid2 = no20.isValid2("))");
        System.out.println(valid2);
    }

}
