package myanswer.linkedlist.medium;

import java.util.WeakHashMap;

/**
 * @FileName: No148.java
 * @Description: 排序链表
 * @Author: admin
 * @Date: 2020/10/22 14:53
 */
public class No148 {

    // 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
    public ListNode sortList(ListNode head) {
        // 归并排序
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = cut(head);
        head = sortList(head);
        head2 = sortList(head2);
        head = merge(head, head2);
        return head;
    }

    private ListNode merge(ListNode node1, ListNode node2) {

        ListNode dummy = new ListNode(-1);
        // 注意这里是dummy，不能是dummy.next，不然为null赋值没有意义
        ListNode curr = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                curr.next = node1;
                node1 = node1.next;
                curr = curr.next;
            } else {
                curr.next = node2;
                node2 = node2.next;
                curr = curr.next;
            }
        }
        if (node1 == null) {
            curr.next = node2;
        } else {
            curr.next = node1;
        }
        return dummy.next;

    }

    private ListNode cut(ListNode head) {

        // 找中间节点，从中间节点开始分割
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }

    /*class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }*/

    public static void main(String[] args) {
        No148 no148 = new No148();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode res = no148.sortList(n1);
        System.out.println(res);
    }






}
