package sword2offer;

public class Question27 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

}
