package MyAnswer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 有些条件不满足，未能AC
public class No102 {

    // 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new LinkedList<>();

        List<TreeNode> l1 = new LinkedList<>();
        List<TreeNode> l2 = new LinkedList<>();
        l1.add(root);
        List<Integer> temp1 = new LinkedList<>();
        temp1.add(root.val);
        res.add(temp1);
        while (!l1.isEmpty()) {
            root = l1.remove(0);
            if (root.left != null) {
                l2.add(root.left);
            }
            if (root.right != null) {
                l2.add(root.right);
            }
            if (l1.isEmpty() && !l2.isEmpty()) {
                l1.addAll(l2);
                List<Integer> temp = new LinkedList<>();
                for (TreeNode treeNode : l2) {
                    temp.add(treeNode.val);
                }
                res.add(temp);
                l2.clear();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        No102 no102 = new No102();
        List<List<Integer>> ans = no102.levelOrder(n1);
        System.out.println(ans);

    }

}
