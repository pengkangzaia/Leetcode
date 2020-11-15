package myanswer.linkedlist.medium;

/**
 * @FileName: No148_2.java
 * @Description: 排序链表2刷
 * @Author: admin
 * @Date: 2020/11/14 20:34
 */
public class No148_2 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = cut(left);
        left = sortList(left);
        right = sortList(right);
        ListNode res = merge(left, right);
        return res;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                res.next = left;
                left = left.next;
            } else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        if (left == null) {
            res.next = right;
        } else {
            res.next = left;
        }
        return dummy.next;
    }

    public ListNode cut(ListNode head) {
        // 用快慢指针找到中间节点，截断
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        // 从prev节点到slow节点进行截断
        prev.next = null;
        return slow;
    }

    public static void main(String[] args) {
        No148_2 no148_2 = new No148_2();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(n1);
        ListNode res = no148_2.sortList(n1);
        System.out.println(res);
    }



}
