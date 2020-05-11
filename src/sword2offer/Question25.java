package sword2offer;

public class Question25 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;
        l21.next = l22;
        Question25 question25 = new Question25();
        ListNode ans = question25.mergeTwoLists(l11, l21);
        System.out.println(ans);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else if (l1 == null) {
            return l2;
        } else {
            // 两个链表都不为空，合并两个链表
            ListNode head = new ListNode(-1);
            ListNode curr = head;
            ListNode curr1 = l1;
            ListNode curr2 = l2;
            ListNode temp = null;
            while (curr1 != null || curr2 != null) {
                if (curr1 != null && curr2 != null) {
                    if (curr1.val <= curr2.val) {
                        temp = curr1.next;
                        curr.next = curr1;
                        curr.next.next = null;
                        curr = curr.next;
                        curr1 = temp;
                    } else {
                        temp = curr2.next;
                        curr.next = curr2;
                        curr.next.next = null;
                        curr = curr.next;
                        curr2 = temp;
                    }
                } else if (curr1 == null && curr2 != null) {
                    temp = curr2.next;
                    curr.next = curr2;
                    curr = curr.next;
                    curr2 = temp;
                } else {
                    temp = curr1.next;
                    curr.next = curr1;
                    curr = curr.next;
                    curr1 = temp;
                }
            }
            return head.next;
        }


    }

}
