package javavaluebooksort;

/**
 * 测试各种排序
 */
public class Test {

    /**
     * 选择排序，每次选择一个最小的 换到前面。
     * @param a
     */
    public  static void selectSort(int[] a){
        for (int i = 0; i <a.length-1 ; i++) {

                int miniddex=i;
            for (int j = i+1; j <a.length ; j++) {
                if(a[j]<a[miniddex])
                    miniddex=j;
            }
            if(i!=miniddex)
            swap(a,i,miniddex);
        }

    }

    /**
     * 直接插入 维护一个前面数组，长度递增 ，每次都保证有序。
     * @param a
     */
    public static void insertSort(int[] a){
        for (int i = 0; i <a.length-1; i++) {

            for (int j = i+1; j >0; j--) {
                if(a[j]<a[j-1])
                    swap(a,j,j-1);
            }
        }
    }

    /**
     * 冒泡  两两比较 将大的元素浮出来，
     * @param a
     */
    public static void bubbleSort(int[] a){
        for (int i = a.length-1; i >0 ; i--) {

            for (int j = 0; j <i ; j++) {
                if(a[j]>a[j+1])
                    swap(a,j,j+1);
            }
        }
    }

    /**
     * 希尔   改良版插入。  让步长内都有序，最后化为插入。
     * @param a
     */
    public static void shellSort(int[] a){
        int step=a.length/2;
        while (step>=1){
            for (int i = step; i <a.length ; i++) {

                for (int j = i-step; j >=0 ; j-=step) {
                    if(a[j+step]<a[j])
                        swap(a,j,j+step);
                }
            }
            step/=2;
        }
    }


    /**
     * 归并   分治，分为左右数组 然后 借助一个数组 完成排序
     * @param a
     */
    public static void mergeSort(int[] a,int lo,int hi){
        if(lo<hi){
            int mid=(lo+hi)/2;
            mergeSort(a,lo,mid);
            mergeSort(a,mid+1,hi);
            merge(a,lo,mid,hi);
        }
    }

    public static void merge(int[] a,int lo,int mid,int hi){
        int n1=mid-lo+1;
        int n2=hi-mid;
        int i,j,k;
        int [] L=new int[n1];
        int [] R=new int[n2];

        for (i = 0,k=lo; i <n1 ; i++,k++) {
            L[i]=a[k];
        }
        for ( i = 0,k=mid+1; i <n2 ; i++,k++) {
            R[i]=a[k];
        }

        for (i = 0, j=0,k=lo; i < n1&&j<n2; k++) {
            if(L[i]<R[j]){
                a[k]=L[i++];
            }else{
                a[k]=R[j++];
            }
        }

        if(i<n1){
            while(i<n1){
                a[k++]=L[i++];
            }
        }
        if(j<n2){
            while(j<n2){
                a[k++]=R[j++];
            }
        }
    }


    /**
     * 快排，1.根据枢纽元返回索引， 2.左右递归排序
     * 选取枢纽元   从左到右，找到比枢纽元小的，交换，从右到左选比他大的， 直到 枢纽元在正确的位置
     */
    public static void quickSort(int[] a,int lo,int hi){
        if(hi<=lo) return;

        int j=partition(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }
    public static int partition(int[] a,int lo,int hi){
        int i=lo,j=hi+1;
        int v=a[lo];

        while (true){

            while (a[++i]<v)
                    if(i==hi)break;
            while (a[--j]>v)
                    if(j==lo)break;
            if(i>=j)break;
            swap(a,i,j);
        }
        swap(a,lo,j);
        return j;
    }


    /**
     *堆排序  1. 构建堆 2. 交换堆顶与最后一个元素位置 ，3.调整堆
     *
     * @return
     */
    public static void heapSort(int[] a){
        int i;
        int len=a.length;
        for (i  = len/2-1; i>=0 ; i--) {
            adjustHeap(a,i,len-1);
        }

        for (i = len-1;i>=0 ; i--) {
            int tmp=a[0];
            a[0]=a[i];
            a[i]=tmp;
            adjustHeap(a,0,i-1);
        }
    }

    public static void adjustHeap(int[] a,int pos,int len){
        int tmp;
        int child;
        for(tmp=a[pos];2*pos+1<=len;pos=child){
            child=2*pos+1;
            if(child<len&&a[child]>a[child+1]) //短路机制
                child++;

            if(a[child]<tmp)
                a[pos]=a[child];
            else
                break;
        }

        a[pos]=tmp;
    }
    public static void main(String[] args) {
        int[] a=new int[]{2,4,3,1};
       // selectSort(a);
       // insertSort(a);
        //bubbleSort(a);
        //shellSort(a);
        //mergeSort(a,0,a.length-1);
        //quickSort(a,0,a.length-1);
        //heapSort(a);
        for(int tmp: a)
        System.out.println(tmp);
    }

    public static void swap(int[] a,int i,int j){
        int tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
