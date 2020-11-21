package myanswer.linkedlist.medium;

/**
 * @FileName: No92.java
 * @Description: 反转链表2
 * @Author: camille
 * @Date: 2020/11/19 23:09
 */
public class No92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(-1);
        temp.next = head;
        int count = n - m + 1;
        ListNode prev = temp;
        ListNode curr = head;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
        }
        ListNode dummy = new ListNode(-1);
        ListNode next = curr;
        ListNode tail = curr;
        while (count > 0) {
            next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
            count--;
        }
        prev.next = dummy.next;
        tail.next = next;
        return temp.next;
    }

    public static void main(String[] args) {
        No92 no92 = new No92();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode ans = no92.reverseBetween(node1, 1, 2);
        System.out.println(ans);
    }

}
