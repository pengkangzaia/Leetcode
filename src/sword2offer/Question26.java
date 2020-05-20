package sword2offer;

public class Question26 {
    // 先序遍历加递归判断两个树是否相等

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (B == null) {
            return false;
        }

        return isSame(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean isSame(TreeNode x, TreeNode y) {
        if (x == null && y == null) {
            return true;
        } else if (x == null && y != null) {
            return false;
        } else if (x != null && y == null) {
            // 这种情况可以认为是子结构，不一定要完全相等
            return true;
        }

        if (x.val == y.val) {
            return isSame(x.left, y.left) && isSame(x.right, y.right);
        } else {
            return false;
        }
    }


}
