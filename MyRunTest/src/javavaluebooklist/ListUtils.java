package javavaluebooklist;



import java.util.HashMap;

/**
 * Created by shkstart on 2017/11/8.
 */
public class ListUtils {

    /**
     * 删除链表中重复的数据 version 1 利用hashmap
     * @param head
     */
    public  static void deleteDupv1(Node head){
       HashMap<Integer,Integer> map=new HashMap<>();
        Node tmp=head;
        Node pre=null;
        while (tmp!=null){
            if(map.containsKey(tmp.data)){
                pre.next=tmp.next;
            }else {
                map.put(tmp.data,1);
                pre=tmp;
            }
            tmp=tmp.next;
        }
    }

    /**
     * version 2 双指针 外指针正常遍历，快指针从当前节点遍历删除
     * @param head
     */
    public  static void deleteDupv2(Node head){
        if(head==null) return;

        Node cur=head;
        while(cur!=null){
            Node fast=cur;

            while (fast.next!=null){
                if(cur.data==fast.next.data){
                    fast.next=fast.next.next;
                }else {
                    fast=fast.next;
                }

            }
            cur=cur.next;
        }

    }

    /**
     * 找出倒数第k个节点,双指针，一个指针先走k-1步，然后一起走，当快指针到尾时，慢指针就是答案
     * @return
     */
    public static Node findElem(Node head,int k){
        if(k<1){ //长度也要判断
            return null;
        }
        Node slow=head;
        Node fast=head;
        for (int i = 0; i<=k-1 ; i++) {
            fast=fast.next;
        }
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    /**
     * 实现链表反转  需要维护当前节点的下一个节点，防止链表断掉接不起来。
     * @param head
     */
    public static Node ReverseList(Node head){
        Node preverseHead=head;
        Node pNode=head;
        Node pPrev=null;

        while (pNode!=null){
            Node pNext=pNode.next;
            if(pNext==null){
                preverseHead=pNode;
            }

            pNode.next=pPrev;
            pPrev=pNode;
            pNode=pNext;
        }

        head=preverseHead;
        return head;
    }

    /**
     * 从尾到头输出链表：1.反转链表 2.栈 3.递归
     */
    public static  void printListReverse(Node head){
        if(head!=null){
            printListReverse(head.next);
            System.out.println(head.data);
        }
    }

    /**
     * 找中间节点   1.遍历出长度 2.双指针， 一步 两步
     * @return
     */
    public  static Node searchMid(Node head){
        Node fast=head;
        Node slow=head;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    /**
     * 检测链表是否有环，  双指针， 相遇则说明有环。
     * @return
     */
    public static boolean isLoopList(Node head){
        Node fast=head;
        Node slow=head;
        if(fast==null){
            return false;
        }
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }

    /**
     * 找到环入口， 先找到相遇点， 然后从从相遇点和起点同时遍历，再相遇为入口
     * @param head
     * @return
     */
    public  static Node findLoopPort(Node head){
        Node fast=head;
        Node slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                break;
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=head;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;

    }

    /**
     * 在不知道头结点的情况下删除节点，1.若为尾节点，无法删除 2.假删除  复制下一个节点的值，然后删除下一个节点。
     * @param head
     * @return
     */
    public static boolean deleteNode(Node n){
        if(n==null||n.next==null)
            return false;
        int tmp=n.data;
        n.data=n.next.data;
        n.next=n.next.next;
        return true;
    }

    /**
     * 判断链表是否相交。 相交即有相同的尾节点，判断尾节点即可. 复杂度为O(len1+len2)
     * @param h1
     * @param h2
     * @return
     */
    public  static boolean isInterserct(Node h1,Node h2){
        if(h1==null||h2==null)
            return false;
        Node tailh1=h1;
        Node tailh2=h2;

        while (tailh1.next!=null)
            tailh1=tailh1.next;
        while (tailh2.next!=null)
            tailh2=tailh2.next;

        return tailh1==tailh2;
    }

    /**
     * 找到第一个相交的节点， 1. 获取两个链表的长度，长的先走len1-len2.然后一起走。
     *                      2.先判断是否相交，
     * @param h1
     * @param h2
     * @return
     */
    public  static Node findFirstInterserct(Node h1,Node h2){
        if(h1==null||h2==null)
            return null;

        Node tailh1=h1;
        int len1=1;
        while (tailh1.next!=null){
            tailh1=tailh1.next;
            len1++;
        }
        Node tailh2=h2;
        int len2=1;
        while (tailh2.next!=null){
            tailh2=tailh2.next;
            len2++;
        }

        if(tailh1!=tailh2)  // 判断是否相交
            return null;

        Node t1=h1;
        Node t2=h2;
        if (len1>len2){
            int d=len1-len2;
            while (d!=0){
                t1=t1.next;
                d--;
            }
        }else {
            int d=len2-len1;
            while (d!=0){
                t2=t2.next;
                d--;
            }
        }


        while (t1!=t2){
            t1=t1.next;
            t2=t2.next;
        }
        return t1;


    }
    public static void main(String[] args) {

        MyLinkedList list1=new MyLinkedList();
        list1.addNewNode(1);
        list1.addNewNode(2);
        list1.addNewNode(3);
        list1.addNewNode(4);
        list1.addNewNode(5);
        Node head1=list1.getHead();
        MyLinkedList list2=new MyLinkedList();
        list2.addNewNode(1);
        list2.addNewNode(2);
        list2.addNewNode(3);
        Node head2=list2.getHead();
        Node tmp1=list2.getNode(list2.length());
        Node tmp2=list1.getNode(4);
        tmp1.next=tmp2;
        System.out.println(findFirstInterserct(head1,head2).data);
      // System.out.println(isInterserct(head1,head2));
      //  Node loopfirst=list.getNode(3);
       // Node looplast=list.getNode(list.length());
       // looplast.next=loopfirst;
       // Node last=list.getNode(list.length()-1);
        //last.next=head;
       // deleteDupv2(head);
       // Node cur=findElem(head,1);
       //System.out.println(findElem(head,5).data);
       //Node cur= ReverseList(head);
      //  list.setHead(cur);
        // list.printList();
       // printListReverse(head);
       // System.out.println(searchMid(head).data);
       // System.out.println(isLoopList(head));
       // System.out.println(findLoopPort(head).data);
       // Node cur=list1.getNode(2);
        //deleteNode(cur);
        //list1.printList();

    }
}
