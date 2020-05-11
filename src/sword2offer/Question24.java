package sword2offer;

public class Question24 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = new ListNode(-1);
        ListNode curr = head;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = first.next;
            first.next = curr;
            curr = next;
        }

        return first.next;
    }

}
