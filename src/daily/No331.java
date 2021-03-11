package daily;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @FileName: No331.java
 * @Description: 验证二叉树的前序序列化
 * @Author: camille
 * @Date: 2021/3/12 1:29
 */
public class No331 {


    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        Deque<String> stack = new ArrayDeque<>();
        String[] strings = preorder.split(",");
        int idx = 0;
        while (idx < strings.length) {
            // 三种情况
            // 数字，直接入栈
            // #，判断之前是否入栈过一次#，如果没有，直接压栈。
            // 如果是，则弹出#和数字（必定为数字）。弹出之后再次进行判断栈顶元素是否满足条件
            String s = strings[idx];
            while (!stack.isEmpty() && stack.peek().equals("#") && s.equals("#")) {
                if (stack.size() >= 2) {
                    stack.pop();
                    stack.pop();
                } else {
                    return false;
                }
            }
            stack.push(s);
            idx++;
        }
        // 当遍历完之后栈只有一个元素并且栈顶为# 或者 栈为空时 返回true
        return stack.isEmpty() || (stack.size() == 1 && stack.peek().equals("#"));
    }

    public static void main(String[] args) {
        No331 no331 = new No331();
        boolean ans = no331.isValidSerialization("9,#,92,#,#");
        System.out.println(ans);
    }


}
