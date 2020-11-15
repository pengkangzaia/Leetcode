package myanswer.linkedlist.medium;

/**
 * @FileName: No328.java
 * @Description: 奇偶链表
 * @Author: admin
 * @Date: 2020/11/15 11:47
 */
public class No328 {

    public ListNode oddEvenList(ListNode head) {
        // 维护三个指针，一个索引值
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        int idx = 1;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (idx % 2 == 1) {
                oddTail.next = curr;
                oddTail = oddTail.next;
                oddTail.next = null;
            } else {
                evenTail.next = curr;
                evenTail = evenTail.next;
                evenTail.next = null;
            }
            curr = next;
            idx++;
        }
        // 把两个链表拼接起来
        oddTail.next = evenHead.next;
        return oddHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        /*n3.next = n4;
        n4.next = n5;*/
        No328 no328 = new No328();
        ListNode ans = no328.oddEvenList(n1);
        System.out.println(ans);
    }

}
