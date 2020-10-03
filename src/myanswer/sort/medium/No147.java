package myanswer.sort.medium;

/**
 * 对链表进行插入排序。
 * 第一个方法的思路错了，
 * 参考答案，写下第二个方法
 */
public class No147 {
    public static void main(String[] args) {
        int[] nums = {4,2,1,3};
        ListNode s1 = new ListNode(nums[0]);
        ListNode s2 = new ListNode(nums[1]);
        ListNode s3 = new ListNode(nums[2]);
        ListNode s4 = new ListNode(nums[3]);

        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = null;

        ListNode ans = insertionSortList(s1);
        System.out.println(ans.toString());


    }

    private static ListNode insertionSortList(ListNode l1) {
        if(l1==null||l1.next==null){
            return l1;
        }

        ListNode h = new ListNode(-1);
        h.next = l1;         //head
        ListNode c = l1;     //curr
        ListNode n = c.next; //next

        while (n!=null){
            if(n.val>=c.val){
                c = c.next;
                n = n.next;
            }else {
                ListNode t = h.next;  //temp
                ListNode p = h; //pre
                while (p!=c){
                    if(n.val<=t.val){
                        //插入到p和t之间
                        c.next = n.next;
                        p.next = n;
                        n.next = t;
                        n = c.next;
                        break;
                    }else {
                        p = p.next;
                        t = t.next;
                    }
                }

            }
        }



        return h.next;
    }



    //第一个方法，顺序反了
    //ListNode a = new ListNode(s.val);
    //        ListNode b = a;
    //
    //        while (s.next!=null){
    //            //判断s的一下个元素的值与a链表表头的值的关系
    //            //ListNode temp1 = s.next.next;
    //            s = s.next;
    //            //s.next = temp1;
    //            //如果a值小于等于s的下一个元素的值，添加下一个元素为表头
    //            if(s.val>=a.val){
    //                /*ListNode temp = s.next;
    //                s.next = a;
    //                a = s;
    //                s = temp;*/
    //                ListNode temp = new ListNode(s.val);
    //                temp.next = a;
    //                a = temp;
    //                b = a;
    //                continue;
    //            }else {
    //                b = a;
    //                while (a.next!=null){
    //                    //不为空，判断该元素与a的下一个元素的值的大小
    //                    if(s.val>a.next.val){
    //                        //插入到a的两元素中间
    //                        ListNode temp1 = new ListNode(s.val);
    //                        ListNode temp2 = a.next;
    //                        a.next = temp1;
    //                        temp1.next = temp2;
    //                        b = a;
    //                        break;
    //                    }else {
    //                        //比较a下一个元素的下一个元素
    //                        a = a.next;
    //                        //continue;
    //                    }
    //                }
    //                //判断a的下一个元素是否为空
    //                if(a.next==null){
    //                    //为空，把s的下一个元素添加到a中
    //                    ListNode temp = new ListNode(s.val);
    //                    a.next = temp;
    //                    a = b;
    //                }
    //            }
    //        }
    //        //判断s的下一个元素是否为空
    //        if(s.next==null){
    //            return a;
    //        }
    //
    //
    //
    //        return a;
}
