package myanswer.tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @FileName: No107.java
 * @Description: 二叉树的层次遍历 II
 * @Author: camille
 * @Date: 2020/10/14 23:11
 */
public class No107 {

    private List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        dfs(root, 0);
        Collections.reverse(list);
        return list;
    }

    public void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        dfs(node.left, level+1);
        while (list.size() <= level) {
            LinkedList<Integer> tem = new LinkedList<>();
            list.add(tem);
        }
        list.get(level).add(node.val);
        dfs(node.right, level+1);
    }

    public static void main(String[] args) {
        No107 no107 = new No107();
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        List<List<Integer>> lists = no107.levelOrderBottom(n1);
        System.out.println(lists);
    }

}
