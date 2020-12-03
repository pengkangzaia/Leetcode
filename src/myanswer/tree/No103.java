package myanswer.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No103.java
 * @Description: 二叉树的锯齿形层次遍历
 * @Author: admin
 * @Date: 2020/11/20 17:04
 */
public class No103 {

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        // 队列添加头节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.poll();
                if (depth % 2 == 0) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
            res.add(temp);
        }
        return res;
    }



}
