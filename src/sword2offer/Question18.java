package sword2offer;

public class Question18 {
    public static void main(String[] args) {
        Question18 question18 = new Question18();
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode ans = question18.deleteNode(n1, 5);
        System.out.println(ans);
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(-1);
        ListNode fir = pre;
        pre.next = head;
        ListNode cur = head;
        while (cur != null) {
            // 判断这个节点是否是我们要寻找的节点
            if (cur.val != val) {
                pre = pre.next;
                cur = cur.next;
            } else {
                // 删除节点
                pre.next = cur.next;
                cur.next = null;
                // 删除节点后要直接返回
                // 否则程序不会终止
                return fir.next;
            }
        }
        return fir.next;
    }

}


