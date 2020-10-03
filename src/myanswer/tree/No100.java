package myanswer.tree;

public class No100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    // 解法二
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        String s1 = treeToString(p);
        String s2 = treeToString(q);
        return s1.equals(s2);
    }

    public String treeToString(TreeNode root) {
        if (root == null) return "@";
        String s = String.valueOf(root.val);
        s += treeToString(root.left);
        s += treeToString(root.right);
        return s;
    }


}
