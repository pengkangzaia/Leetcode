package MyAnswer.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No94 {
    // 给定一个二叉树，返回它的中序 遍历。
    public List<Integer> list = new ArrayList<>();

    /**
     * 递归版本
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list = inorderTraversal(root.left);
        list.add(root.val);
        list = inorderTraversal(root.right);
        return list;
    }

    /**
     * 非递归版本，用栈实现
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {

        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                list.add(root.val);
                root = root.left;
            }
        }
        return list;
    }


}
