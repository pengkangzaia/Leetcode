package MyAnswer.tree;

public class No543 {
    // 给定一棵二叉树，你需要计算它的直径长度。
    // 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
    // 这条路径可能穿过也可能不穿过根结点。
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth + rightDepth + 1;
    }

    private int maxDepth(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = maxDepth(head.left);
        int rightDepth = maxDepth(head.right);
        res = Math.max(res, leftDepth + rightDepth + 1);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
