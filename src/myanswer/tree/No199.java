package myanswer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No199.java
 * @Description: 二叉树的右视图
 * @Author: admin
 * @Date: 2020/11/20 14:55
 */
public class No199 {

    private List<Integer> res = new LinkedList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == currSize - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

}
