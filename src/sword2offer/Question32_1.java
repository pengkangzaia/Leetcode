package sword2offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Question32_1 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n4.left = n5;
        Question32_1 question32_1 = new Question32_1();
        int[] ans = question32_1.levelOrder(n1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }


    public int[] levelOrder(TreeNode root) {
        // 定义两个queue，一个queue存储当前行，另一个queue存储下一行
        ArrayList<Integer> array = new ArrayList<>();
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            array.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] ans = new int[array.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = array.get(i);
        }
        return ans;
    }

}
