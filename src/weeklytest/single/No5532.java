package weeklytest.single;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @FileName: No5532.java
 * @Description: No5532.java类说明
 * @Author: camille
 * @Date: 2020/10/4 11:04
 */
public class No5532 {

    public boolean isEvenOddTree(TreeNode root) {
        Stack<TreeNode> odd = new Stack<>();
        Stack<TreeNode> even = new Stack<>();
        List<List<Integer>> list = new LinkedList<>();
        odd.add(root);
        while (!odd.isEmpty() || !even.isEmpty()) {
            List<Integer> oddList = new LinkedList<>();
            while (!odd.isEmpty()) {
                TreeNode poll = odd.pop();
                if (poll.val % 2 == 0) {
                    return false;
                }
                oddList.add(poll.val);
                // 奇数层先右后左
                if (poll.right != null) {
                    even.add(poll.right);
                }
                if (poll.left != null) {
                    even.add(poll.left);
                }
            }
            list.add(oddList);
            List<Integer> evenList = new LinkedList<>();
            while (!even.isEmpty()) {
                TreeNode poll = even.pop();
                if (poll.val % 2 == 1) {
                    return false;
                }
                evenList.add(poll.val);
                // 偶数层先左后右
                if (poll.left != null) {
                    odd.add(poll.left);
                }
                if (poll.right != null) {
                    odd.add(poll.right);
                }
            }
            list.add(evenList);
        }
        for (List<Integer> nums : list) {
            for (int i = 0; i < nums.size() - 1; i++) {
                // 严格单调递减
                if (nums.get(i+1) >= nums.get(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No5532 no5532 = new No5532();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        boolean evenOddTree = no5532.isEvenOddTree(node1);
        System.out.println(evenOddTree);
    }


}
