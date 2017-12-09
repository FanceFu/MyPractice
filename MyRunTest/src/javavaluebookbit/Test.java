package javavaluebookbit;

/**
 *
 */
public class Test {
    /**
     * 判断一个数是否为2的n次方  将1移位 然后判断是否相等version 1
     */
    public static boolean isPower(int n){
       if(n<1) return false;
        int i=1;
        while (i<=n){
            if(i==n)
                return true;

            i<<=1;
        }
        return false;

    }

    /**
     * 用去除最后一位一的方法  n&(n-1)
     * @param n
     * @return
     */
    public static boolean isPowerv2(int n){
       if(n<1)return false;
       int m=n&(n-1);

       return m==0;

    }


    /**
     * 判断二进制中一的个数
     * @param n
     * @return
     */
    public  static int countOne(int n){
        int count=0;
        while (n>0){


            n=n&(n-1);

            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(isPower(4));
        System.out.println(isPowerv2(7));
        System.out.println(isPowerv2(8));
        System.out.println(countOne(4));
    }
}
