package javanowcoder;

/**
 * 牛客网刷的题：包括 剑指offer 程序员面试金典
 */
public class Solution {
    /**
     * 斐波那契数列  1 1 2 3 5....
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if(n<1)return -1;
        if(n==1||n==2) return 1;
        int pre1=1;
        int pre2=1;
        int cur=0;
        for (int i = 3; i <=n ; i++) {
            cur=pre1+pre2;

            pre2=pre1;
            pre1=cur;
        }
        return cur;
    }

    /**
     * 二进制中1的个数
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
         int count=0;
         while (n!=0){
             n=n&(n-1);
             count++;
         }
         return count;
    }

    public static void main(String[] args) {

        System.out.println(NumberOf1(1));
        //System.out.println(Fibonacci(5));
    }
}
