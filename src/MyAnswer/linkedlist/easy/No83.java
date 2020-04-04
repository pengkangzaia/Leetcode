package MyAnswer.linkedlist.easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No83 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;

        ListNode ans = deleteDuplicates(l1);
        System.out.println(ans.toString());

    }

    private static ListNode deleteDuplicates(ListNode l1) {
        if(l1==null||l1.next==null){
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode curr = l1;
        head.next = curr;
        ListNode next = l1.next;

        while (true){
            if(next==null){
                break;
            }
            if(curr.val==next.val){
                //删除next节点
                curr.next = next.next;
                next.next = null;
                next = curr.next;
            }else {
                curr = curr.next;
                next = next.next;
            }
        }





        return head.next;
    }
}
