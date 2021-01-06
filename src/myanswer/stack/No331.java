package myanswer.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @FileName: No331.java
 * @Description: 验证二叉树的前序序列化
 * @Author: camille
 * @Date: 2020/12/30 20:09
 */
public class No331 {


    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return true;
        }
        // todo 有思路，写不出代码我靠。
        String[] nums = preorder.split(",");
        Deque<String> stack = new LinkedList<>();
        return true;
    }


    public static void main(String[] args) {
        No331 no331 = new No331();
        boolean ans = no331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
        System.out.println(ans);
    }

}
