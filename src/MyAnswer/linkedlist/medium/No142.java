package MyAnswer.linkedlist.medium;



import java.util.HashMap;
import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No142 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        ListNode first = detectCycle(node1);
        System.out.println(first.toString());
    }

    private static ListNode detectCycle(ListNode l1) {
        ListNode curr = l1;
        HashSet<ListNode> hs = new HashSet<>();

        boolean flag = false;
        while (curr!=null){
            if(hs.contains(curr)){
                flag = true;
                break;
            }else {
                hs.add(curr);
                curr = curr.next;
            }
        }
        return curr;

    }

}
