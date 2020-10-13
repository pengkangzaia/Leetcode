package daily;

import myanswer.linkedlist.easy.ListNode;

/**
 * @FileName: No24.java
 * @Description: 两两交换链表中的节点
 * @Author: admin
 * @Date: 2020/10/13 17:07
 */
public class No24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode currNode = head;
        ListNode nextNode = head.next;
        // 需要前一个节点
        ListNode prevNode = dummy;
        while (nextNode != null) {
            currNode.next = nextNode.next;
            nextNode.next = currNode;
            prevNode.next = nextNode;
            prevNode = currNode;
            currNode = currNode.next;
            // 注意这里要判断是否为空
            if (currNode != null) {
                nextNode = currNode.next;
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        No24 no24 = new No24();
        ListNode listNode = no24.swapPairs(n1);
        System.out.println(listNode);
    }

}
