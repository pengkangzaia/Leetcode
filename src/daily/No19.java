package daily;

import myanswer.linkedlist.easy.ListNode;

/**
 * @FileName: No19.java
 * @Description: 删除链表的倒数第 n 个节点
 * @Author: camille
 * @Date: 2020/10/18 19:38
 */
public class No19 {

    /*public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 需要dummy节点来索引头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        // 给定的n保证是有效的
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        ListNode slow = head;
        // 删除节点，则需要保留上一个节点
        ListNode slowPrev = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            slowPrev = slowPrev.next;

        }
        // 删除slow节点
        slowPrev.next = slow.next;
        slow.next = null;
        return dummy.next;
    }*/

    public static ListNode removeNthFromEnd(ListNode head, int index) {
        // 找到第k个节点和第k个节点前一个节点，删除它
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while (fast != null && index > 0) {
            index--;
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            prev = prev.next;
            fast = fast.next;
        }

        // 删除slow节点
        prev.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = removeNthFromEnd(n1, 2);
        System.out.println(listNode);
    }


}
