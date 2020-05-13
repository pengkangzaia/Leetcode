package sword2offer;

public class Question68_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (isParent(root.left, p) && isParent(root.left, q)) {
                root = root.left;
            } else if (isParent(root.right, p) && isParent(root.right, q)) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    public boolean isParent(TreeNode root, TreeNode a) {
        if (root == null) {
            return false;
        }
        if (root.val == a.val) {
            return true;
        }
        return isParent(root.left, a) || isParent(root.right, a);
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 递归方式
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor1(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor1(root.right, p, q);
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }

        return root;

    }

}
