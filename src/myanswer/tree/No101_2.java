package myanswer.tree;

import java.util.List;

/**
 * @FileName: No101_2.java
 * @Description: 对称二叉树
 * @Author: admin
 * @Date: 2020/11/20 10:05
 */
public class No101_2 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        return left.val == right.val && (dfs(left.left, right.right)) && (dfs(left.right, right.left));
    }


}
