package myanswer.linkedlist.easy;

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
public class No141 {
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

        boolean flag = hasCycleMethod3(node1);
        System.out.println(flag);
        System.out.println(hasCycleMethod2(node1));
    }

    public static boolean hasCycleMethod3(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode curr = head;
        int idx = 0;
        while (curr != null) {
            if (map.containsKey(curr)) {
                return true;
            }
            map.put(curr, idx);
            idx++;
            curr = curr.next;
        }
        return false;

        // 快慢指针
        // 快慢指针
        /*if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;*/

    }

    private static boolean hasCycleMethod2(ListNode node1) {
        if(node1==null||node1.next==null){
            return false;
        }
        ListNode fast = node1.next;
        ListNode slow = node1;
        boolean falg = false;
        while (true){
            if(fast==null||fast.next==null){
                break;
            }
            if(fast==slow){
                falg = true;
                break;
            }else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return falg;
    }

    //思路：节点的地址即引用是不同的，把引用作为参照物存入哈希表中，而不仅仅是把节点的值存入哈希表中
    private static boolean hasCycle(ListNode l1) {
        /*if(l1==null||l1.next==null){
            return false;
        }*/
        ListNode curr = l1;
        //用hashset更快
        HashSet<ListNode> hs = new HashSet<>();
        //HashMap<Integer,ListNode> hp = new HashMap<>();
        //int n = 0;
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

        return flag;
    }
}
