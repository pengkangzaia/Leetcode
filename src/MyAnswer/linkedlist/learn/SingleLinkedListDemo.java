package MyAnswer.linkedlist.learn;



public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode n1 = new HeroNode(1,"卡密尔1","青钢影1",null);
        HeroNode n2 = new HeroNode(2,"卡密尔2","青钢影2",null);
        HeroNode n3 = new HeroNode(3,"卡密尔3","青钢影3",null);
        HeroNode n4 = new HeroNode(4,"卡密尔4","青钢影4",null);
        HeroNode n5 = new HeroNode(5,"卡密尔5","青钢影5",null);

        SingleLinkedList s = new SingleLinkedList();
        s.addByOrder(n4);
        s.addByOrder(n2);
        s.addByOrder(n1);
        s.addByOrder(n3);
        s.addByOrder(n5);
        s.show();
        System.out.println("==============================================");
        HeroNode n6 = new HeroNode(2,"卡密尔","青钢影",null);
        s.update(n6);
        s.show();
        s.delete(1);
        s.delete(5);
        s.delete(3);
        System.out.println("==============================================");
        s.show();

    }
}



class SingleLinkedList{

    public HeroNode head = new HeroNode(-1,"","",null);


    //添加到单向链表尾部
    public void add(HeroNode node){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        //遍历单项链表节点，直到有个节点的next域为null
        while (true){
            if(temp.next==null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    //根据顺序添加链表节点
    public void addByOrder(HeroNode node){
        //不用判断链表是否为空，从head到第一个元素开始遍历
        HeroNode temp = head;
        while (true){
            if(temp.next==null){
                break;
            }else if(temp.next.no > node.no){
                break;
            }else temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    //修改节点name和nickName
    public void update(HeroNode newListNode){
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true){
            if(temp==null){
                break;
            }else if(temp.no == newListNode.no){
                flag = true;
                break;
            }else temp = temp.next;
        }
        if(flag){
            temp.name = newListNode.name;
            temp.nickName = newListNode.nickName;
        }else {
            System.out.println("修改失败");
        }
    }


    //删除相应no节点
    public void delete(int no){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp==null){
                break;
            }else if(temp.next.no==no){
                flag = true;
                break;
            }else temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("未找到相应节点");
        }
    }


    //显示链表
    public void show(){
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if(temp==null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }

    }
}


class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName, HeroNode next) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
        this.next = next;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
