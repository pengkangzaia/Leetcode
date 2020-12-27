package myanswer.tree;

import myanswer.linkedlist.easy.ListNode;

/**
 * @FileName: No109_2.java
 * @Description: 有序链表转二叉搜索树
 * @Author: camille
 * @Date: 2020/12/27 23:16
 */
public class No109_2 {

    // 关键是找链表的中间节点，用快慢指针
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { return null; }
        return buildTree(head, null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if(left == right) { return null; } // 区间是左闭右开的，所以如果两者相同是不可能的
        ListNode mid = getMedium(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    // 快慢指针
    private ListNode getMedium(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        // 左闭右开，right取不到
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        No109_2 no109_2 = new No109_2();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        TreeNode treeNode = no109_2.sortedListToBST(n1);
        System.out.println(treeNode);
    }


}
