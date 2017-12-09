package javavaluebookstack;

import java.util.Arrays;

/**
 * 数组实现，   1.是否为空， 2.出，3.进。4。获取栈顶元素 5.判断栈是否满了，扩容
 */
public class MyStackArray<E> {
    private Object[] stack;
    private int size;

    public MyStackArray() {
        stack=new Object[10];//初始容量为10
    }


    public boolean isEmpty(){
        return size==0;
    }

    public E peek(){
        if(isEmpty())
            return null;
        return (E) stack[size-1];
    }

    public  E pop(){
        E e=peek();
        stack[size-1]=null;
        size--;
        return e;
    }
    public void push(E item){
        ensureCapacity(size+1);
        stack[size++]=item;

    }

    /**
     * 判断是否满了
     * @param size
     */
    public void ensureCapacity(int size){
        int len=stack.length;
        if(size>len){
            int newLen=10;
            stack = Arrays.copyOf(stack,newLen+size);
        }
    }

    public static void main(String[] args) {
        MyStackArray<Integer> s=new MyStackArray<>();
        for (int i = 0; i <20 ; i++) {
            s.push(i);
        }

        System.out.println(s.size);
        System.out.println(s.peek());
    }
}
