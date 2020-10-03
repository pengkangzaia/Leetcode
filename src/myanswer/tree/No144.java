package myanswer.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class No144 {

    // 递归写法 2020/7/13 11：06 AC
    private List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }

    // 利用栈模拟递归 2020/7/13 11：21 AC
    public List<Integer> preorderTraversalByStack(TreeNode root) {
        if (root == null) {
            return res;
        }
        TreeNode pop = new TreeNode(-1);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            pop = stack.pop();
            res.add(pop.val);
            // 先压右子树，弹出来的时候就是最晚
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return res;
    }

}
