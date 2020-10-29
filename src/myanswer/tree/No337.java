package myanswer.tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @FileName: No337.java
 * @Description: 打家劫舍3
 * @Author: admin
 * @Date: 2020/10/29 15:13
 */
public class No337 {

    // 选择了当前节点，他的子节点就不能取
    // 没有选择当前节点，则可以选择他的子节点
    // 每一个节点记录能够获取的最大值需要额外的递归备忘录记录这个信息

    private HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        // 抢当前这家+下下家
        int rob = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int not_rob = rob(root.left) + rob(root.right);
        map.put(root, Math.max(rob, not_rob));
        return Math.max(rob, not_rob);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        No337 no337 = new No337();
        int ans = no337.rob(node1);
        System.out.println(ans);
    }

}
