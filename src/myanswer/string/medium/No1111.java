package myanswer.string.medium;

import java.util.Stack;

/**
 * @FileName: No1111.java
 * @Description: No1111.java类说明
 * @Author: admin
 * @Date: 2021/3/12 13:57
 */
public class No1111 {

    /**
     * 输入：seq = "(()())"
     * 输出：[0,1,1,1,1,0]
     *
     * 输入：seq = "()(())()"
     * 输出：[0,0,0,1,1,0,1,1]
     */


    public int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.equals("")) return new int[0];
        Stack<Character> stack = new Stack<>();
        int[] res = new int[seq.length()];
        //遍历
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {//入栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
                res[i] = stack.size() % 2;
                stack.push(c);
            } else {//出栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
                stack.pop();
                res[i] = stack.size() % 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No1111 no1111 = new No1111();
        int[] ans = no1111.maxDepthAfterSplit("()(())()");
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }


}
