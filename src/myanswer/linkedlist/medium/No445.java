package myanswer.linkedlist.medium;

/**
 * @FileName: No445.java
 * @Description:  两数相加 II
 * @Author: camille
 * @Date: 2021/2/20 15:19
 */
public class No445 {

    // 可以用栈来求解

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode curr1 = r1;
        ListNode curr2 = r2;
        int carry = 0;
        while (curr1 != null || curr2 != null) {
            int num = carry + curr1.val + curr2.val;
            curr.next = new ListNode(num % 10);
            carry = num / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
            curr = curr.next;
        }
        if (curr1 == null) {
            while (curr2 != null) {
                int num = carry + curr2.val;
                curr.next = new ListNode(num % 10);
                carry = num / 10;
                curr2 = curr2.next;
                curr = curr.next;
            }
        }
        if (curr2 == null) {
            while (curr1 != null) {
                int num = carry + curr1.val;
                curr.next = new ListNode(num % 10);
                carry = num / 10;
                curr1 = curr1.next;
                curr = curr.next;
            }
        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return reverse(dummy.next);

    }

    private ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            ListNode prev = dummy.next;
            dummy.next = curr;
            curr.next = prev;
            curr = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        No445 no445 = new No445();
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;


        ListNode nn1 = new ListNode(5);
        ListNode nn2 = new ListNode(6);
        ListNode nn3 = new ListNode(4);
        nn1.next = nn2;
        nn2.next = nn3;

        ListNode ans = no445.addTwoNumbers(n1, nn1);
        System.out.println(ans);
    }


}
