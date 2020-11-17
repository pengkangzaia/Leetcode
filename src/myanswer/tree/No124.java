package myanswer.tree;

import java.util.Map;

/**
 * @FileName: No124.java
 * @Description: 二叉树中的路径最大和
 * @Author: admin
 * @Date: 2020/11/17 11:23
 */
public class No124 {

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        // 可能的中间结果，两边的子树加上当亲节点，不包括父节点
        res = Math.max(res, root.val + leftMax + rightMax);
        // 其他两种情况，选择一边的子树加上当前节点加上父节点
        return root.val + Math.max(leftMax, rightMax);
    }

}
