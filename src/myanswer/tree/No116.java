package myanswer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @FileName: No116.java
 * @Description: 填充每个节点的下一个右侧节点指针
 * @Author: camille
 * @Date: 2020/11/21 13:26
 */
public class No116 {

    // BFS层次遍历可以解决这个问题，但是题目要求用常数级空间复杂度
    // 这里尝试一下递归
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        // 完全二叉树，有右子树就一定有左子树
        connect(root.left);
        connect(root.right);
        return root;
    }

    // 我再试试BFS，练练手
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                // 这一步最重要
                if (i != currSize - 1) {
                    node.next = queue.peek();
                } else {
                    node.next = null;
                }
            }
        }
        return root;
    }



}
