package myanswer.tree;

public class No236 {

    // 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        // 后序遍历查找p和q。分两个子树
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        // p和q在两个子树中（异侧）
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null) {
            // p和q都在左子树中
            return leftNode;
        } else return rightNode; // p和q都在右子树中
    }

}
