package sword2offer;

import java.util.ArrayList;

public class Question54 {

    ArrayList<Integer> arrayList = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        // 中序遍历和后序遍历都可以
        // 这里采用后序遍历
        mid(root);
        return arrayList.get(arrayList.size() - k);
    }

    public void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        arrayList.add(root.val);
        mid(root.right);
    }

}
