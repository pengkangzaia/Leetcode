package myanswer.tree;

public class No112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        // DFS遍历节点
        /*if (sum == 0 && root == null) {
            return true;
        } else if (root == null) {
            return false;
        }
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);*/

        if (root == null) {
            return false;
        }
        // 叶子节点判断
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }

        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);

    }


}
