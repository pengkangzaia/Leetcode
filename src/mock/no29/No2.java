package mock.no29;

import java.util.HashSet;

/**
 * @FileName: No2.java
 * @Description: No2.java类说明
 * @Author: admin
 * @Date: 2021/1/29 16:08
 */
public class No2 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class FindElements {

        private HashSet<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            // dfs遍历
            root.val = 0;
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            set.add(root.val);
            if (root.left != null) {
                root.left.val = 2 * root.val + 1;
            }
            if (root.right != null) {
                root.right.val = 2 * root.val + 2;
            }
            dfs(root.left);
            dfs(root.right);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */


}
