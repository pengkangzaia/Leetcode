package myanswer.tree;

import java.util.Arrays;

public class No105 {

    // 根据一棵树的前序遍历与中序遍历构造二叉树。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 数组，子树开始，子树结束
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[0]);
        int m = 0; // 头节点在中序遍历数组的位置
        for (int index = 0; index < inorder.length; index++) {
            if (preorder[0] == inorder[index]) {
                m = index;
                head.left = buildTree(Arrays.copyOfRange(preorder, 1, m + 1),
                        Arrays.copyOfRange(inorder, 0, m));
                head.right = buildTree(Arrays.copyOfRange(preorder, m + 1, preorder.length),
                        Arrays.copyOfRange(inorder, m + 1, inorder.length)); // inorder这里应该是m+1
                break;
            }
        }
        return head;

    }

    public static void main(String[] args) {
        int[] a = {3, 9, 20, 15, 7};
        int[] b = {9, 3, 15, 20, 7};
        No105 no105 = new No105();
        TreeNode root = no105.buildTree(a, b);
        System.out.println(root);
    }


}
