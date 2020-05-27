package MyAnswer.tree;

import java.util.Stack;

public class No226 {

    // 翻转一棵二叉树。
    //          4
    //      2       7
    //    1   3   6   9
    // 转为 4 7 2 9 6 3 1

    private TreeNode temp;

    public TreeNode invertTree(TreeNode root) {
        // 递归版
        /*if (root == null ||
                (root.left == null && root.right == null)) {
            return root;
        } else {
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;*/
        // 非递归版
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode ans = root;
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n2.left = n3;
        No226 no226 = new No226();
        TreeNode treeNode = no226.invertTree(n1);
        System.out.println(treeNode);
    }
}
