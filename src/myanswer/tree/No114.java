package myanswer.tree;

public class No114 {

    // 给定一个二叉树，原地将它展开为一个单链表。
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            // 保存右子树
            TreeNode originRight = root.right;
            root.right = null;
            // 把当前节点的左子树加到右边
            root.right = root.left;
            root.left = null;
            // 把右子树加到当前节点的最右边
            TreeNode curr = root;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = originRight;
            // 当前节点变成它的右节点
            root = root.right;
            // 直到当前节点为空
        }
    }


}
