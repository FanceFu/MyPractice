package javavaluebookqueue;

import java.util.TreeSet;

/**
 * 链表实现   isEmpty offer pop size
 */

class Node<E>{
    Node<E> next=null;
    E data;

    public Node(E data) {
        this.data = data;
    }
}

public class MyQueue<E> {
    private Node<E> head=null;
    private Node<E> tail=null;

    public boolean isEmpty() {
        return head == tail;
    }

    public void offer(E data){
        Node<E> newNode=new Node<>(data);
        if(head==null&&tail==null) //队列为空
            head=tail=newNode;
        else{
            tail.next=newNode;
            tail=newNode;
        }
    }

    public E pop(){
        if(isEmpty())
            return null;
        E data =head.data;
        head=head.next;
        return data;
    }

    public  int size(){
        Node<E> tmp =head;
        int n=0;
        while (tmp!=null){
            n++;
            tmp=tmp.next;
        }
        return n;
    }


    public static void main(String[] args) {
        MyQueue<Integer> q=new MyQueue<>();
        System.out.println(q.isEmpty());

        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q.size());
        q.pop();
        System.out.println(q.size());


    }
}
