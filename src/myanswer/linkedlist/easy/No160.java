package myanswer.linkedlist.easy;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No160 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        ListNode n7 = new ListNode(5);
        ListNode n8 = new ListNode(0);
        ListNode n9 = new ListNode(1);
        n7.next = n8;
        n8.next = n9;
        n9.next = n3;

        ListNode ans =  getIntersectionNode(n1,n7);
        System.out.println(ans.toString());

    }



    public static ListNode getIntersectionNode(ListNode a, ListNode b){

        //https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
        //居然还有这种做法？叹为观止！太聪明了！！！！


        //思路有点偏，太复杂了，有更加简单的方法
        //a尾接b头
/*        while (a.next!=null){
            a = a.next;
        }
        a.next = b;
        ListNode aEnd = a;
        ListNode slow = a;
        ListNode fast = b;
        while (fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                a.next = null;
                return fast;
            }
        }
        a.next = null;

        return null;*/



        //简单方法
        ListNode headA = a;
        ListNode headB = b;
        while (headA!=headB){
            headA = headA!=null?headA.next:b;
            headB = headB!=null?headB.next:a;
        }

        return headA;
    }
}
