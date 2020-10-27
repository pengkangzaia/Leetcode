package myanswer.tree;

import myanswer.linkedlist.medium.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @FileName: No144_2.java
 * @Description: 二叉树的前序遍历，2刷
 * @Author: admin
 * @Date: 2020/10/27 9:31
 */
public class No144_2 {

    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraverse(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        return res;
    }

}
