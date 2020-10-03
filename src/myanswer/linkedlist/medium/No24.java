package myanswer.linkedlist.medium;

public class No24 {

    // 2020/7/13 11：02 AC
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        // 需要头节点
        ListNode dump = new ListNode(-1);
        dump.next = head;
        // 两两交换
        ListNode prev = dump;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = next.next;
            next.next = curr;
            prev.next = next;
            prev = curr;
            curr = curr.next;
            if (curr != null) {
                next = curr.next;
            } else break;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        // ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;
        System.out.println(node1);
        No24 no24 = new No24();
        ListNode reversed = no24.swapPairs(node1);
        // 这里不应该打印node1，而是打印返回结果。
        System.out.println(reversed);
    }

}
