package daily;

import myanswer.linkedlist.easy.ListNode;

/**
 * @FileName: No143.java
 * @Description: 重排链表
 * @Author: camille
 * @Date: 2020/10/20 21:26
 */
public class No143 {

    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 找到链表中间节点
        // 把后半部分链表和前半部分分开，后面的链表进行反转
        // 拼接两个链表
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        ListNode list2 = slow.next;
        slow.next = null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = list2;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
            curr = next;
        }

        // 合并两链表
        ListNode head2 = dummy.next;
        ListNode res = new ListNode(-2);
        curr = res;
        while (head != null || head2 != null) {
            if (head != null) {
                curr.next = head;
                curr = curr.next;
                head = head.next;
            }
            if (head2 != null) {
                curr.next = head2;
                curr = curr.next;
                head2 = head2.next;
            }
        }

        head = res;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
        System.out.println(l1);
        No143 no143 = new No143();
        no143.reorderList(l1);
        System.out.println(l1);
    }

}
