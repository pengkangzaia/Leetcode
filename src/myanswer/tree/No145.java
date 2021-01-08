package myanswer.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @FileName: No145.java
 * @Description: 后序遍历二叉树
 * @Author: admin
 * @Date: 2020/12/24 14:01
 */
public class No145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.add(0, root.val);
                root = root.right; // 右子樹
            } else {
                TreeNode tem = stack.pop();
                root = tem.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        No145 no145 = new No145();
        List<Integer> ans = no145.postorderTraversal(node1);
        System.out.println(ans);
    }

}
