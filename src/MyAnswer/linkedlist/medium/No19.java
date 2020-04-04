package MyAnswer.linkedlist.medium;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No19 {
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

        ListNode ans = removeNthFromEnd(n1,1);
        System.out.println(ans.toString());
    }

    private static ListNode removeNthFromEnd(ListNode l1, int n) {
        if(l1==null||n==0){
            return l1;
        }
        ListNode head = new ListNode(-1);
        head.next = l1;

        ListNode pre = head;    //当前节点的之前一个节点，用于删除当前节点作为定位
        ListNode curr = l1;     //当前节点
        ListNode flagNode = l1; //标志节点
        while (n!=0){
            flagNode = flagNode.next;
            n--;
        }

        while (flagNode!=null){
            pre = pre.next;
            curr = curr.next;
            flagNode = flagNode.next;
        }
        //删除当前节点
        pre.next = curr.next;
        curr.next = null;

        return head.next;

    }
}
