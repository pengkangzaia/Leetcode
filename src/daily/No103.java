package daily;

import myanswer.linkedlist.medium.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @FileName: No103.java
 * @Description: 二叉树的锯齿形层序遍历
 * @Author: admin
 * @Date: 2020/12/22 9:52
 */
public class No103 {


    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int currSize = queue.size();
            LinkedList<Integer> temp = new LinkedList<>();
            for (int i = 0; i < currSize; i++) {
                TreeNode node = queue.poll();
                if (depth % 2 == 0) {
                    // 正序，从左往右
                    temp.addLast(node.val);
                } else {
                    // 倒序，从右往左
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

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(10);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        No103 no103 = new No103();
        List<List<Integer>> ans = no103.zigzagLevelOrder(node1);
        System.out.println(ans);
    }


}
