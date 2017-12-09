package javavaluebooklist;

/**
 * Created by shkstart on 2017/11/8.
 * 实现单链表，
 */


public class MyLinkedList {

    //增加节点,删除，长度，冒泡排序链表，打印,在指定的节点处插入节点

    private  Node head=null;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    /**
     * 在链表尾部插入一个节点
     * @param val
     */
    public void addNewNode(int val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            return;
        }
        Node tmp=head;

        while(tmp.next!=null){
            tmp=tmp.next;
        }

        tmp.next=newNode;

    }

    /**
     * 在指定的节点处插入节点
     * @param index
     */
    public boolean addNewNodeIndex(int index,int data){
        //找到索引的前一个节点，p  c.next=p.next; p.next=c

        if(index<1||index>length()){
            return false;
        }
        Node newNode=new Node(data);
        if(index==1){
            newNode.next=head;
            head=newNode;  //更新头结点
            return true;
        }

        int i=1;
        Node preNode=head;
        Node curNode=preNode.next;
        while (curNode!=null){
            if(i==index){
                newNode.next=curNode;
                preNode.next=newNode;
                return true;
            }
            preNode=preNode.next;
            curNode=curNode.next;
            i++;
        }
        return false;
    }
    /**
     * 根据索引删除节点
     * @param index
     * @return  成功 true
     */
    public boolean deleteNode(int index){
        if(index<1||index>length()){
            return false;
        }

        if(index==1){
            head=head.next;
            return true;
        }

        int i=1;
        Node preNode=head;
        Node curNode=preNode.next;
        while(curNode!=null){
            if(i==index){
                preNode.next=curNode.next;
                return true;
            }
            preNode=preNode.next;
            curNode=curNode.next;
            i++;
        }

        return false;


    }

    /**
     * 获取链表长度
     * @return
     */
    public int length(){
        int length=0;
        Node tmp=head;
        while(tmp!=null){
            length++;
            tmp=tmp.next;
        }

        return length;
    }

    /**
     * 用插入排序进行排序
     * @return 头结点
     */
    public Node orderList(){
        Node nextNode=null;
        int tmp=0;
        Node curNode=head;

        while(curNode.next!=null){
            nextNode=curNode.next;
            while(nextNode!=null){
                if(curNode.data>nextNode.data){
                    tmp=curNode.data;
                    curNode.data=nextNode.data;
                    nextNode.data=tmp;
                }

                nextNode=nextNode.next;
            }
            curNode=curNode.next;

        }
        return head;
    }

    /**
     * 获取指定节点
     * @return
     */
    public Node getNode(int index){
        if(index<1||index>length()){
            return null;
        }
        if(index==1) return head;
        int i=1;
        Node tmp=head;
        while (i<index){
            tmp=tmp.next;
            i++;
        }
        return tmp;
    }

    /**
     * 打印链表
     */
    public void printList(){
        Node tmp=head;
        while(tmp!=null){
            System.out.println(tmp.data);
            tmp=tmp.next;
        }
    }


    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addNewNode(5);
        list.addNewNode(4);
        list.addNewNode(3);
        list.addNewNode(2);
        list.addNewNode(1);

        /*System.out.println("length:"+list.length());
        list.printList();
        System.out.println("--------");
        list.deleteNode(1);
        list.printList();
        System.out.println("--------");
        list.orderList();
        list.printList();*/

        /*list.orderList();
        list.printList();*/
        //System.out.println(list.addNewNodeIndex(1,10));
        //list.printList();
        System.out.println(list.getNode(1).data);
    }
}
