package javavaluebookarray;

import javavaluebooksort.Test;

import java.util.*;

/**
 * Created by shkstart on 2017/11/9.
 */
public class day01 {
    /**
     * 找到数组中的最小值与最大值 1.遍历两遍 分别获得最小 最大值
     * 2.遍历一遍，维护 min max 变量。
     * 3.取双元素法， 相邻的两个数 大的和max 比 ， 小的数与min 比 。
     *
     * @return
     */
    public static int[] getMaxAndMin(int[] a){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <a.length-1 ; i++) {
            int curmin=a[i]>a[i+1]?a[i+1]:a[i];
            int curmax=a[i]>a[i+1]?a[i]:a[i+1];
            if(curmin<min)
                min=curmin;
            if(curmax>max)
                max=curmax;
        }


        return new int[]{min,max};
    }

    /**
     * 找到数组中第二大的数 维护两个最大的数， 遍历两遍即可，一遍找出最大，一遍第二大（遍历一遍亦可以）
     * @param a
     * @return
     */
    public static int findsecMax(int[] a){
        int maxone=Integer.MIN_VALUE;
        int maxsec=Integer.MIN_VALUE;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]>maxone)
                maxone=a[i];

        }
        for (int i = 0; i <a.length; i++) {
            if(a[i]<maxone&&a[i]>maxsec){
                maxsec=a[i];
            }
        }

        return maxsec;
    }


    /**
     * 求最大子数组之和，
     * @param a
     * @return
     */
    public static int maxSubArray(int[] a){
        if(a==null||a.length<=0)
            return 0;
        int curSum=0;
        int maxSum=0;
        for (int i = 0; i <a.length ; i++) {

            curSum+=a[i];
            if(curSum>maxSum)
                maxSum=curSum;
            if(curSum<0)
                curSum=0;
        }
        return maxSum;
    }


    /**
     * 找出重复次数最多的数  1.用哈希表保存次数，
     * @param a
     * @return
     */
    public static int findMaxDup(int[] a){
        if(a==null||a.length<=0) return -1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <a.length ; i++) {
            if(map.containsKey(a[i])){
                map.put(a[i],map.get(a[i])+1);
            }else {
                map.put(a[i],1);
            }

        }
        int maxCount=1;
        int res=0;
        Iterator iter=map.entrySet().iterator(); //遍历hashmap
        while (iter.hasNext()){
            Map.Entry entry= (Map.Entry) iter.next();
            int key=(Integer) entry.getKey();
            int value=(Integer) entry.getValue();
            if(value>maxCount){
                maxCount=value;
                res=key;
            }
        }


    return res;
    }


    /**
     *求数组中两两相加等于 target组合种数  1.暴力搜索 2.排序 3.借助哈希表
     * @param a
     * @return
     */
    public static void findSum(int[] a,int target){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(a[i])){
                System.out.println(a[i]+" "+map.get(a[i]));
            }else {
                map.put(target-a[i],a[i]);
            }
        }
    }


    /**
     * 把一个数循环右移k位 12345 2 -> 45123      1.借助一个数组 on on2. on o1利用逆序数组，逆序3次即可。
     * @param a
     * @param
     */
    public static int[] reverseKth(int[] a,int k){
        if(k<1||k>a.length)return null;
        int[] res=new int[a.length];
        int j=0;
        for (int i = a.length-k; i <a.length ; i++,j++) {
            res[j]=a[i];

        }
        for (int i = 0; j <res.length ; i++,j++) {
            res[j]=a[i];
        }
        return  res;
    }

    /**
     * 逆序
     * @param a
     * @param lo
     * @param hi
     */
    public static void reverse(int[] a,int lo,int hi){
        for(;lo<hi;lo++,hi--){
            int tmp=a[lo];
            a[lo]=a[hi];
            a[hi]=tmp;
        }
    }

    public static void shiftKth(int[] a,int k){
        int n=a.length;
        k=k%n; //可以防止 k比n大
        reverse(a,0,n-k-1);
        reverse(a,n-k,n-1);
        reverse(a,0,n-1);
    }


    /**
     * 找最小的第k个数   1.排序 2.选取枢纽元的方法 3.计数排序 4 部分选择排序 5.堆排序 6.二分
     * @return
     */
    public static int getKMin3(int[] a,int k){
        int maxN=100;
        int[] count=new int[maxN];
        for (int i = 0; i <a.length ; i++) {
            count[a[i]]++;
        }
        int v=0;
        for(int sumCount=0;v<maxN;v++){
            sumCount+=count[v];

            if(sumCount>=k)
                break;
        }
        return v;
    }

    public static int getKMin4(int[] a,int k){
       int i,j;
        for ( i = 0; i < k; i++) {
            int minindex=i;
            for ( j = i+1; j < a.length; j++) {
                if(a[j]<a[minindex])
                    minindex=j;
            }
            swap(a,i,minindex);
        }
        return a[k-1];
    }

    public static void swap(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }


    /**
     * 找出数组中唯一一个出现一次的数， 1.位运算  异或0
     * @param a
     * @return
     */
        public static int findNotDouble(int[] a){
            int res=0;
            for (int i = 0; i <a.length ; i++) {
                res^=a[i];
            }
            return res;
        }

    /**
     * 除一个数外 都出现了n次 找出来  1. 哈希表  on on 2.位运算  数出现了n次，二进制对应位数1也出现了n 次
     * @return
     */
    public  static int findNotNth1(int[] a,int count){
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <a.length ; i++) {
            if (map.containsKey(a[i])) {
                map.put(a[i], map.get(a[i]) + 1);
            } else {
                map.put(a[i], 1);
            }
        }


            int res=0;
            Iterator iter=map.entrySet().iterator(); //遍历hashmap
            while (iter.hasNext()){
                Map.Entry entry= (Map.Entry) iter.next();
                int key=(Integer) entry.getKey();
                int value=(Integer) entry.getValue();
                if(value!=count){
                    res=key;
                    break;
                }
            }
            return res;
    }

    public  static int findNotNth2(int[] a,int count){
        int[] bitCount=new int[32];
        //计算数组中所有二进制数位上1出现的次数
        for (int i = 0; i <a.length ; i++) {

            for (int j = 0; j < 32; j++) {
                bitCount[j]+=((a[i]>>j)&1);
            }
        }
        //某位上的结果不能被n整除 ， 目标数字在这一位上为1
        int appearOne=0;
        for (int i = 0; i <32 ; i++) {
            if(bitCount[i]%count!=0){
                appearOne+=(1<<i);
            }
        }

        return appearOne;
    }

    /**
     * 找出数组中唯一重复的元素  1-n-1 存放在 n的数组中 ，其中一个数重复 1. 哈希表  on on 2.求和法 3.异或 4.
     * @param a
     * @return
     */
    public static int findOneDup(int[] a){

        int sum=0;
        for (int i = 0; i <a.length ; i++) {
            sum+=a[i];
        }
        int nSum=(1+a.length-1)*(a.length-1)/2;
        return sum-nSum;
    }



    /**
     * 用递归的方法 求出数组中最大的数
     * @param a
     * @return
     */
    public static int getMax(int[] a,int begin){
            int len=a.length-begin;
        if(len==1)
            return a[begin];
        else {
            return Math.max(a[begin],getMax(a,begin+1));
        }
    }


    /**
     * 数组中一个数字减去它右边子数组的一个数字得到一个差值  求最大差值  1. 暴力搜索  2.分治  3.动态规划
     * 优化方法  ： 求解diff[i+1]时 只用到了 diff[i] max[i]  故可用变量代替
     * @return
     */
    public static int getMaxInArr(int [] a){
        if(a==null||a.length<=1) return Integer.MIN_VALUE;

        //int[] diff=new int[a.length];
        //int[] max=new int[a.length];
        //diff[0]=0;
        //max[0]=a[0];
        int diff=0;
        int max=a[0];
        for (int i = 1; i <a.length ; i++) {
            diff=Math.max(diff,max-a[i]);
            max=Math.max(max,a[i]);
        }
        return diff;
    }


    /**
     * 一个升序排列的数组  求绝对值最小的元素 1.暴力 2.二分查找
     * @param a
     * @return
     */
    public static int getMinAbsVal(int[] a){
        if(a==null||a.length<=0) return Integer.MIN_VALUE;
        if(a[0]>0) return a[0];
        if(a[a.length-1]<0) return a[a.length-1];
        int lo=0;
        int hi=a.length-1;
        int mid=0;
        while (true){
             mid=lo+(hi-lo)/2;
            if(a[mid]==0)
                return 0;
            else if(a[mid]>0){
                if(a[mid-1]>0)
                    hi=mid-1;
                else if(a[mid-1]==0)
                    return 0;
                else break; //没有找到分界点
            } else if(a[mid]<0){
                if(a[mid+1]<0)
                    lo=mid+1;
                else if(a[mid+1]==0)
                    return 0;
                else break;
            }


        }
        int min=0;
        if(a[mid]>0){
            if(a[mid]<Math.abs(a[mid-1]))
                min=a[mid];
            else min=a[mid-1];
        }else {
            if(Math.abs(a[mid])<a[mid+1])
                min=a[mid];
            else min=a[mid+1];
        }
        return min;
    }


    /**
     * 数组中含有重复的元素， n1 n2 求这两个数在数组中出现位置的最小距离
     * @param a
     * @return
     */
    public static int getMinDistance(int[] a,int n1,int n2){
        if(a==null) return Integer.MIN_VALUE;
        int n1_index=-1;
        int n2_index=-1;
        int min_dist=Integer.MIN_VALUE+1;
        for (int i = 0; i <a.length ; i++) {
            if (a[i] == n1) {
                n1_index = i;
                if (n2_index >= 0)
                    min_dist = Math.min(Math.abs(min_dist), Math.abs(n1_index -n2_index));
            }
            if(a[i]==n2){
                n2_index=i;
                if(n1_index>=0)
                    min_dist= Math.min(Math.abs(min_dist), Math.abs(n2_index - n1_index));
            }
        }
        return min_dist;
    }

    /**
     * 数组中相邻元素差值为1  求指定数字第一次出现的位置 1. 暴力搜索 2.跳跃搜索 ：由于相邻元素差值1.故 下标变化为 i+|t-a[i]|
     *
     * @param a
     * @param n
     * @return
     */
    public static int findIndex(int[] a ,int n){
        if(a==null) return -1;
        int i=0;
        while (i<a.length){
            if(a[i]==n)
                return i;
            else {
                i=i+Math.abs(n-a[i]);
            }
        }
        return -1;
    }

    /**
     * a[0,mid-1] a[mid,n-1] 各自升序 整体排序 ，不能使用额外空间  （若能使用空间  即为归并排序）
     * 利用左右分别有序的特点，  从左到右  a[i]>a[mid] 则 交换 ，然后 用插入法 找到a[mid] 应该在的位置
     */
    public static void  voidSort(int[] a,int mid){
        for (int i = 0; i <mid; i++) {
            if(a[i]>a[mid])
                swap(a,i,mid);
            findRightIndex(a,mid);
        }
    }
    public static void  findRightIndex(int[] a,int mid){
        for (int i =mid; i <a.length-1 ; i++) {
            if (a[mid]>a[mid+1])
                swap(a,mid,mid+1);
        }
    }

    /**
     * 求两个有序数组的交集  1.二路归并 2. 顺序哈希表， 3.散列法
     * @param a
     * @param b
     * @return
     */
    public static ArrayList<Integer> mixed(int[] a,int[] b){
        if(a==null||b==null||a.length<=0||b.length<=0)
            return null;
        ArrayList<Integer> res=new ArrayList<>();
        int i=0;
        int j=0;
        while (i<a.length&&j<b.length){
            if(a[i]==b[j]) {
                res.add(a[i]);
                i++;
                j++;
            }
            else if(a[i]>b[j])
                    j++;
            else i++;
        }
        return res;
    }


    /**
     * 数组中除0外 都不重复， 随机抽5个数 判断是否连续相邻。 1.允许乱序 2.0匹配任意数 3.全0 连续 4.4个0 也连续
     *   非0最大-非0最小+1<=5 则连续
     * @param a
     * @return
     */
    public static boolean isContinuous(int[] a){
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=0){
                if(a[i]>max)
                    max=a[i];
                if(a[i]<min)
                    min=a[i];
            }
        }
        return max-min<=4;
    }


    /**
     * 求逆序对的个数 1.暴力搜索   o(n^2) 2. 分治归并
     * @param a
     * @return
     */
    public static int reverseCount1(int[] a){
        int count=0;
        for (int i = 0; i < a.length-1; i++) {
            for (int j =i+1; j <a.length ; j++) {
                if(a[i]>a[j])
                    count++;
            }
        }
        return count;
    }


    /**
     * 求最小3元组 距离 distance=max(ai-bj,ai-ck,bj-ck) 3 个数组升序  1.暴力搜索 o(n^3)
     * 2.最小距离法 o(n+n+n)
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int minDistance(int[] a,int[] b,int[] c){
        int i=0;
        int j=0;
        int k=0;
        int minDis=Integer.MAX_VALUE;
        while (i<a.length&&j<b.length&&k<c.length){

            int curDis=Math.max(Math.abs(a[i]-b[j]),Math.max(Math.abs(a[i]-c[k]),Math.abs(b[j]-c[k])));
            int minCur=Math.min(a[i],Math.min(b[j],c[k]));
            if(curDis<minDis)
                minDis=curDis;

            if(minCur==a[i])
                i++;
            if(minCur==b[j])
                j++;
            if(minCur==c[k])
                k++;
        }
        return minDis;
    }

    public static void main(String[] args) {
        int[] a=new int[]{1,2};
        int[] b=new int[]{3,4};
        int[] c=new int[]{5,6};
        System.out.println(minDistance(a,b,c));
       // System.out.println(reverseCount1(a));
       // System.out.println(isContinuous(a));
       // int[] b=new int[]{1,3,5,7,9};
       // ArrayList<Integer> res=mixed(a,b);
       // voidSort(a,5);
        //System.out.println(a);

       // System.out.println(findIndex(a,4));
       // System.out.println(getMinDistance(a,4,8));
        //System.out.println(getMinAbsVal(a));
        //System.out.println(getMaxInArr(a));
       // System.out.println(getMaxInArr(a));
        //System.out.println(findOneDup(a));
       // System.out.println(getMax(a,0));
        //System.out.println(findNotNth1(a,3));
        //System.out.println(findNotNth2(a,3));
        //System.out.println(findNotDouble(a));
        //System.out.println(getKMin4(a,3));
        //shiftKth(a,2);
        //int[] res=reverseKth(a,2);
       // findSum(a,4);
        //System.out.println(findMaxDup(a));
       // System.out.println(maxSubArray(a));
        //System.out.println(findsecMax(a));
       // int[] res=getMaxAndMin(a);
        //for (int i = 0; i < res.length; i++) {
        //   System.out.println(a[i]);
       // }
        //for (Integer tmp: res
       //      ) {
        //    System.out.println(tmp);
       // }
    }
}
