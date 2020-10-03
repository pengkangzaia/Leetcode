package myanswer.tree;

import java.util.ArrayList;
import java.util.List;

public class No101 {

    public List<Integer> leftList = new ArrayList<>();
    public List<Integer> rightList = new ArrayList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        midOrder(root.left);
        antiMidOrder(root.right);
        if (leftList.size() != rightList.size()) {
            return false;
        } else {
            for (int i = 0; i < leftList.size(); i++) {
                if (!leftList.get(i).equals(rightList.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void antiMidOrder(TreeNode right) {
        if (right == null) {
            rightList.add(Integer.MIN_VALUE);
            return;
        }
        antiMidOrder(right.right);
        rightList.add(right.val);
        antiMidOrder(right.left);
    }

    private void midOrder(TreeNode left) {
        if (left == null) {
            leftList.add(Integer.MIN_VALUE);
            return;
        }
        midOrder(left.left);
        leftList.add(left.val);
        midOrder(left.right);

    }

    ArrayList<Integer> list = new ArrayList<>();
    // 尝试2：中序遍历，不可以。中序遍历不能得到想要的结果
    // [1,2,2,2,null,2]
    public boolean isSymmetric2(TreeNode root) {

        midTraverse(root);

        Integer[] array = list.toArray(new Integer[list.size()]);
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            if (!array[start].equals(array[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private void midTraverse(TreeNode root) {
        if (root == null) return;
        midTraverse(root.left);
        list.add(root.val);
        midTraverse(root.right);
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        No101 no101 = new No101();
        boolean flag = no101.isSymmetric2(n1);
        System.out.println(flag);
    }


}
