package myanswer.tree;

import java.util.ArrayList;

public class No538 {
    /**
     * 这是我的解法，太慢了
     */
    private ArrayList<TreeNode> list = new ArrayList<>();
    private int temp = 0;
    /*
     * 给定一个二叉搜索树（Binary Search Tree），
     * 把它转换成为累加树（Greater Tree)，
     * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
     */
    public TreeNode convertBST(TreeNode root) {
        // 把二叉搜索树中序遍历，得到一个递增的数组
        if (root == null) {
            return null;
        }
        convertBST(root.left);
        temp = root.val;
        if (list.size() > 0) {
            for (TreeNode treeNode : list) {
                treeNode.val += temp;
            }
        }
        list.add(root);
        convertBST(root.right);
        return root;
    }
    /**
     * leetcode的解法：
     * 解法的关键在于应该按照节点值降序遍历所有节点，
     * 同时记录我们已经遍历过的节点值的和，
     * 并把这个和加到当前节点的值中。
     * 这种遍历树的方法被称作 反序中序遍历
     */
    public TreeNode convertBST1(TreeNode root) {
        // 把二叉搜索树中序遍历，得到一个递增的数组
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        temp += root.val;
        root.val = temp;
        convertBST(root.left);
        return root;
    }


}
