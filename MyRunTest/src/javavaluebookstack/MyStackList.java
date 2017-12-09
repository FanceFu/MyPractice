package javavaluebookstack;



/**
 * 链表实现   1.是否为空， 2.出，3.进。4。获取栈顶元素
 */
class Node<E>{
    Node<E> next=null;
    E data;

    public Node(E data) {
        this.data = data;
    }
}

public class MyStackList<E> {
    Node<E> top=null;
    public boolean isEmpty(){
        return top==null;
    }

    public void push(E data){
        Node<E> newNode=new Node<>(data);
        newNode.next=top;
        top=newNode;
    }

    public E pop(){
        if(isEmpty())
            return null;
        E data=top.data;
        top=top.next;

        return data;
    }

    public E peek(){
        if(isEmpty())
            return null;
        return top.data;
    }

    public static void main(String[] args) {
        MyStackList<Integer> s=new MyStackList<>();
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());

        s.pop();
        System.out.println(s.peek());
    }
}
