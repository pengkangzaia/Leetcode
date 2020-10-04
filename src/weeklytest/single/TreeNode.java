package weeklytest.single;

/**
 * @FileName: TreeNode.java
 * @Description: TreeNode.java类说明
 * @Author: camille
 * @Date: 2020/10/4 11:07
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
