package sword2offer;

import java.util.LinkedList;
import java.util.List;

public class Question34 {

    LinkedList<Integer> path = new LinkedList<>();
    LinkedList<List<Integer>> ans = new LinkedList<>();

    // 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
    // 从树的根节点开始往下一直到 (叶节点)(叶节点即树的最末尾) 所经过的节点形成一条路径。
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ans;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        target = target - root.val;
        // 叶节点
        if (target == 0 && root.left == null && root.right == null) {
            ans.add(new LinkedList<>(path));
            // 这里不能写return
            // return;
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.removeLast();

    }

}
