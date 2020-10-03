package myanswer.linkedlist.easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No21 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode ans = mergeTwoLists(l11, l21);
        System.out.println(ans.toString());
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null && l2 != null) {
            return l2;
        } else if (l1 != null && l2 == null) {
            return l1;
        } else {
            ListNode head = new ListNode(-1);
            ListNode curr = new ListNode(-2);
            head.next = curr;

            while (l1 != null || l2 != null) {
                if (l1 == null && l2 != null) {
                    curr.next = l2;
                    break;
                } else if (l1 != null && l2 == null) {
                    curr.next = l1;
                    break;
                } else {
                    if (l1.val <= l2.val) {
                        curr.next = l1;
                        l1 = l1.next;
                        curr = curr.next;
                    } else {
                        curr.next = l2;
                        l2 = l2.next;
                        curr = curr.next;
                    }
                }

            }
            //删除辅助节点
            ListNode temp = head.next;
            head.next = temp.next;
            temp.next = null;
            return head.next;
        }

    }


}
