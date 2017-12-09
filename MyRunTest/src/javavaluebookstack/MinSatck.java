package javavaluebookstack;

/**
 * 利用两个栈实现，一个保存最小元素： 1.同步出元素，存的时候 min栈重复存。
 * 2。 如果当前栈出了 最小的，把 min栈也出
 */
public class MinSatck {
    MyStackList<Integer> elem;
    MyStackList<Integer> min;

    public MinSatck() {
        elem=new MyStackList<>();
        min=new MyStackList<>();
    }

    public  void push(int data){
        elem.push(data);
        if(min.isEmpty()){
            min.push(data);
        }else if(data<min.peek()){
            min.push(data);
        }
    }


    public int pop(){
        int topData=elem.peek();
        elem.pop();
        if(topData==min.peek()){
            min.pop();
        }
        return topData;
    }
    public int min(){
        if(min.isEmpty())
            return Integer.MAX_VALUE;
        return min.peek();
    }

    public  int peek(){
        if(elem.isEmpty())
            return Integer.MAX_VALUE;
        return elem.peek();
    }
    public static void main(String[] args) {
        MinSatck s=new MinSatck();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.peek());
        System.out.println(s.min());
        s.push(0);
        System.out.println(s.min());
        s.pop();
        System.out.println(s.min());
    }
}
