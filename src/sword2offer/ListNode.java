package sword2offer;

public class ListNode {

    int val;
    ListNode next;

    ListNode (int val) {
        this.val = val;
    }

    public ListNode headInsert(ListNode listNode) {
        ListNode head = new ListNode(-1);
        ListNode curr = listNode;
        while (curr != null) {
            ListNode temp = curr;
            curr = curr.next;
            temp.next = head.next;
            head.next = temp;
        }
        return head.next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
