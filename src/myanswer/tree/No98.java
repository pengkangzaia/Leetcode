package myanswer.tree;

import java.util.Stack;

public class No98 {
    // 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    public boolean isValidBST(TreeNode root) {
        // 中序遍历这棵树，如果后一个值比前一个值小，则不是二叉搜索树
        if (root == null) {
            return true;
        }
        // 用栈实现二叉搜索树的中序遍历
        Stack<TreeNode> stack = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre >= root.val) {
                    return false;
                }
                // 更新pre的值
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }
}
