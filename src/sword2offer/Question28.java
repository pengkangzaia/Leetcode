package sword2offer;

public class Question28 {

    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public boolean recur(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;// 子节点
        if (a == null || b == null || a.val != b.val) return false;
        return recur(a.left, b.right) && recur(a.right, b.left);
    }

}
