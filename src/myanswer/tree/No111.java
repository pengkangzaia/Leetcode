package myanswer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No111.java
 * @Description: 二叉树的最小深度
 * @Author: admin
 * @Date: 2020/11/20 12:02
 */
public class No111 {
    // 叶子节点是左右节点为null的节点，要找这个节点。
    // 如果只有一边为null是不可以的
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
