package sword2offer;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Question32_3 {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        Question32_3 question32_3 = new Question32_3();
        List<List<Integer>> ans = question32_3.levelOrder(n1);
        System.out.println(ans);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        //ArrayList<Integer> array = new ArrayList<>();
        if (root == null) {
            return new LinkedList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> lists = new LinkedList<>();

        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            // 从左到右
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.removeFirst();
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            lists.add(temp);
        }
        int row = 1;
        for (List<Integer> list : lists) {
            if (row % 2 == 0) {
                Collections.reverse(list);
            }
            row++;
        }

        return lists;
    }

}
