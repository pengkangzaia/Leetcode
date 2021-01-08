package myanswer.linkedlist.easy;

/**
 * @FileName: No203.java
 * @Description: 移除链表元素
 * @Author: admin
 * @Date: 2021/1/4 9:40
 */
public class No203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != val) {
                ListNode temp = new ListNode(curr.val);
                tail.next = temp;
                tail = temp;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        No203 no203 = new No203();
        ListNode node = no203.removeElements(node1, 6);
        System.out.println(node);
    }


}
