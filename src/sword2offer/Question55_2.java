package sword2offer;

public class Question55_2 {

    public boolean isBalanced(TreeNode root) {
        // 判断左节点，右节点构成的树是否平衡
        // 判断root是否平衡
        if (root == null) {
            return true;
        }
        boolean self = Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1;
        return self && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // 方法2，后序遍历+剪枝
    public boolean isBalanced1(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) <= 1 ? (1 + Math.max(left, right)) : -1;
    }

}
