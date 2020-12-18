package myanswer.linkedlist.medium;

/**
 * @FileName: No86.java
 * @Description: 分割链表
 * @Author: admin
 * @Date: 2020/11/2 19:13
 */
public class No86 {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode tail1 = dummy1;
        ListNode tail2 = dummy2;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                tail1.next = curr;
                // 需要在这里更新curr值，不然下一步curr=tail1的next会赋值为空
                curr = curr.next;
                tail1 = tail1.next;
                tail1.next = null;
            } else {
                tail2.next = curr;
                curr = curr.next;
                tail2 = tail2.next;
                tail2.next = null;
            }
        }
        tail1.next = dummy2.next;
        return dummy1.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        No86 no86 = new No86();
        ListNode partition = no86.partition(node1, 5);
        System.out.println(partition);
    }


}
