package sword2offer;

public class Question22 {

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
        Question22 question22 = new Question22();
        ListNode node = question22.getKthFromEnd(n1, 2);
        System.out.println(node);

    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 注释部分位链表反转的代码，不适合此题
        /*if (head == null || head.next == null) {
            return head;
        }

        // 翻转链表，遍历翻转后的链表，得到第k个元素
        ListNode first = new ListNode(-1);
        ListNode curr = head;
        ListNode next = null; // 用于保存当前节点的位置
        while (curr != null) {
            next = curr.next;
            curr.next = first.next;
            first.next = curr;
            curr = next;
        }
        ListNode cur = first;
        while (k != 0) {
            cur = cur.next;
            k--;
        }
        return cur;*/
        if (head == null || head.next == null) {
            return head;
        }

        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        cur = head;
        while (n - k > 0) {
            n--;
            cur = cur.next;
        }
        return cur;
    }

}
