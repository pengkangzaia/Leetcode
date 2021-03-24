package mock.mock29;

import daily.TreeNode;

/**
 * @FileName: FindTilt.java
 * @Description: FindTilt.java类说明
 * @Author: admin
 * @Date: 2021/3/24 16:52
 */
public class FindTilt {

    /**
     * 给定一个二叉树，计算 整个树 的坡度 。
     *
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。
     * 如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     *
     * 整个树 的坡度就是其所有节点的坡度之和。
     */

    private int sum = 0;

    public int findTilt(TreeNode root) {
        // 一个节点，记录左子树节点和，右子树节点和
        getSum(root);
        return sum;
    }

    public int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        sum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }


}
