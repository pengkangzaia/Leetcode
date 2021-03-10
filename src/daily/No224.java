package daily;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No224.java
 * @Description: 基本计算器
 * @Author: admin
 * @Date: 2021/3/10 9:42
 */
public class No224 {

    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "1 + 1"
     * 输出：2
     * 示例 2：
     *
     * 输入：s = " 2-1 + 2 "
     * 输出：3
     * 示例 3：
     *
     * 输入：s = "(1+(4+5+2)-3)+(6+8)"
     * 输出：23
     *  
     *
     * 提示：
     *
     * 1 <= s.length <= 3* 10^5
     * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
     * s 表示一个有效的表达式
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/basic-calculator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int calculate(String s) {
        Deque<String> stack = new LinkedList<>();
        char[] chars = new char[s.length() + 2];
        chars[0] = '(';
        chars[s.length() + 1] = ')';
        System.arraycopy(s.toCharArray(), 0, chars, 1, s.length());
        int idx = 0;
        while (idx < chars.length){
            char c = chars[idx];
            if (Character.isDigit(c)) {
                long num = c - '0';
                while (idx + 1 < chars.length && Character.isDigit(chars[idx + 1])) {
                    num = num * 10 + (chars[idx + 1] - '0');
                    idx++;
                }
                stack.push(String.valueOf(num));
            } else if (c == '+') {
                stack.push("+");
            } else if (c == '-') {
                stack.push("-");
            } else if (c == '(') {
                stack.push("(");
            } else if (c == ')') {
                int res = 0;
                while (!stack.peek().equals("(")) {
                    int currNum = Integer.valueOf(stack.pop());
                    if (!stack.peek().equals("(")) {
                        String symbol = stack.pop();
                        if (symbol.equals("-")) {
                            currNum = -1 * currNum;
                        } else {
                            currNum = currNum;
                        }
                    }
                    res += currNum;
                }
                stack.pop(); // 弹出左括号
                stack.push(String.valueOf(res));
            }
            idx++;
        }
        return Integer.valueOf(stack.peek());
    }

    public static void main(String[] args) {
        No224 no224 = new No224();
        System.out.println(no224.calculate("2147483647"));
    }

}
