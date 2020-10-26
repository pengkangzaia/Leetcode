package myanswer.tree;

/**
 * @FileName: No235.java
 * @Description: 二叉搜索树的最近公共祖先
 * @Author: admin
 * @Date: 2020/10/22 19:20
 */
public class No235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }

}
