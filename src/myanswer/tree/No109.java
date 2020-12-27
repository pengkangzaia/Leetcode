package myanswer.tree;

import myanswer.linkedlist.easy.ListNode;

/**
 * @FileName: No109.java
 * @Description: 有序链表转换二叉搜索树
 * @Author: camille
 * @Date: 2020/12/27 23:09
 */
public class No109 {

    // 整体思路：将链表转化为数组，然后用108题的解法求解
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { return null; }
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        int[] nums = new int[n];
        curr = head;
        int idx = 0;
        while (curr != null) {
            nums[idx] = curr.val;
            idx++;
            curr = curr.next;
        }
        return getBST(nums);
    }

    public TreeNode getBST(int[] nums) {
        int n = nums.length;
        if (n == 0) { return null; }
        if (n == 1) { return new TreeNode(nums[0]); }
        TreeNode root = new TreeNode(nums[n / 2]);
        int[] temp1 = new int[n/2];
        System.arraycopy(nums, 0, temp1, 0, n/2);
        root.left = getBST(temp1);
        int[] temp2 = new int[n-n/2-1];
        System.arraycopy(nums, n/2 + 1, temp2, 0, n-n/2-1);
        root.right = getBST(temp2);
        return root;
    }

    public static void main(String[] args) {
        No109 no109 = new No109();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        TreeNode treeNode = no109.sortedListToBST(n1);
        System.out.println(treeNode);
    }


}
