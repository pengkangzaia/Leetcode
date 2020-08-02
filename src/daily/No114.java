package daily;

public class No114 {

    // 我的解法 有错误 在if (root == null || root.left == null) 这个地方
    public void flatten(TreeNode root) {
        if (root == null || root.left == null) {
            return;
        }

        if (root.right != null) {
            flatten(root.left);
            flatten(root.right);
            TreeNode tem = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root.right;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = tem;
        } else {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
        }
    }

    // leetcode 解法
    public void flatten1(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            TreeNode originRight = root.right;
            root.right = null;
            root.right = root.left;
            root.left = null;
            TreeNode cur = root;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = originRight;
            root = root.right;
        }
    }


    private TreeNode pre = null; //最后一个节点的右子树节点
    // leetcode 递归解法：后序遍历的变形
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten2(root.right);
        flatten2(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n5;
        n2.left = n3;
        n2.right = n4;
        n5.right = n6;
        No114 no114 = new No114();
        no114.flatten2(n1);
        System.out.println(n1);
    }

}
