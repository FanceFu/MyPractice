package javavaluebookqueue;

import javavaluebookstack.MyStackList;

/**
 * 两个栈实现队列，  old new 当new栈不为空时不允许 old栈向new栈倒入值
 */
public class TwoStackQueue<E> {
    private MyStackList<E> olds=new MyStackList<>();
    private MyStackList<E> news=new MyStackList<>();

    public void offer(E data){
        olds.push(data);
    }

    public E pop(){
        if(news.isEmpty()){
            while (!olds.isEmpty()){
                news.push(olds.pop());
            }
        }
        return news.pop();
    }

    public boolean isEmpty(){
        return olds.isEmpty()&&news.isEmpty();
    }


    public static void main(String[] args) {
        TwoStackQueue<Integer> q=new TwoStackQueue<>();
        q.offer(1);
        q.offer(2);
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}
