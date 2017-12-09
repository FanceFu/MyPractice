package javavaluebookqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现栈   1，q1只有一个元素 让q1 出 2. q1不止一个  q1出入q2，  最后一个元素不入q2， 然后q2所有元素入q1
 */
public class TwoQueueStack<E> {
    LinkedList<E> q1=new LinkedList<>();
    LinkedList<E> q2=new LinkedList<>();

    public TwoQueueStack() {

    }

    public boolean isEmpty(){
        return q1.isEmpty();
    }

    public void push(E data){
        q1.add(data);
    }

    public E pop(){
        if(q1.size()==1){
            return q1.poll();
        }
        int len=q1.size();
        int curlen=1;
        while (curlen<len){
            q2.add(q1.poll());
            curlen++;
        }

        E data=q1.poll();

        while (!q2.isEmpty()){
            q1.add(q2.poll());
        }

        return data;

    }

    public static void main(String[] args) {
        TwoQueueStack<Integer>  s=new TwoQueueStack<>();
        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.isEmpty());
        System.out.println(s.pop());
    }
}
