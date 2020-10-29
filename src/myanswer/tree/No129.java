package myanswer.tree;

/**
 * @FileName: No129.java
 * @Description: 求根到叶子节点数字之和
 * @Author: admin
 * @Date: 2020/10/29 10:11
 */
public class No129 {

    private int res;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int preVal) {
        // 递归结束条件
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            // 叶节点
            res += preVal * 10 + root.val;
            return;
        }
        preVal = preVal * 10 + root.val;
        dfs(root.left, preVal);
        dfs(root.right, preVal);
    }

    public static void main(String[] args) {
        No129 no129 = new No129();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        int ans = no129.sumNumbers(n1);
        System.out.println(ans);
    }

}
