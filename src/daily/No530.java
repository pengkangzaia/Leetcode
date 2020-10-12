package daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @FileName: No530.java
 * @Description: No530.java类说明
 * @Author: admin
 * @Date: 2020/10/12 19:22
 */
public class No530 {

    private LinkedList<Integer> list = new LinkedList<>();

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        // 二叉搜索树的中序排序就是顺序的
        // Collections.sort(list);
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, Math.abs(list.get(i) - list.get(i-1)));
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        n1.right = n2;
        n2.left = n3;
        No530 no530 = new No530();
        int ans = no530.getMinimumDifference(n1);
        System.out.println(ans);
    }


}
