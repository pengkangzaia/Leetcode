package myanswer.linkedlist.easy;

import java.util.ArrayList;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 */
public class No234 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(-129);
        ListNode n2 = new ListNode(-129);

        n1.next = n2;


        boolean flag = isPalindrome(n1);
        System.out.println(flag);
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //把链表值拷贝到数组中
        ArrayList<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = nums.size() - 1;
        while (front <= back) {
            if (nums.get(front).equals(nums.get(back))) {
                front++;
                back--;
            } else {
                return false;
            }
        }
        return true;
    }
}


        //不能用stack，会破坏链表的结构
        //下列方法不正确
        /*if(head==null||head.next==null){
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        Stack<ListNode> stack1 = new Stack<>();
        stack1.push(head);
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            curr.next = null;
            stack.push(curr);
            curr = next;
        }
        ListNode headReverse = stack.pop();
        ListNode temp = headReverse;
        while (!stack.empty()){
            ListNode temp1 = stack.pop();
            temp.next = temp1;
            temp = temp.next;
        }
        temp.next = null;

        ListNode headOriginal = stack1.pop();
        while (headOriginal!=null&&headReverse!=null){
            if(headOriginal.val==headReverse.val){
                headOriginal = headOriginal.next;
                headReverse = headReverse.next;
            }else {
                return false;
            }
        }*/

