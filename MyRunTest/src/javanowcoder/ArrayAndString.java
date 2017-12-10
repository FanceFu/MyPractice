package javanowcoder;

/**
 * Created by shkstart on 2017/12/9.
 */
public class ArrayAndString {
    /**
     * 判断字符串中字符是否全部不同  1.暴力搜索 2.排序后 检查相邻字符 3.构建boolean数组 4.使用位向量
     * @param str
     * @return
     */
    public static  boolean isUniqueChars3(String str){
        if(str.length()>256) return false;
        boolean[] charSet=new boolean[256];
        for (int i = 0; i <str.length() ; i++) {
            if(charSet[str.charAt(i)]){
                return false;
            }else {
                charSet[str.charAt(i)]=true;
            }
        }
        return true;
    }

    /**
     * 求旋转数组中最小值  1.直接搜索 2.二分
     *  如果 lo hi mid所表示的值都相同 不能二分判断 ，只能顺序查找
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int [] array) {
        if(array==null||array.length<=0)return 0;
        int lo=0;
        int hi=array.length-1;
        int mid=lo;
        while (array[lo]>=array[hi]){
            if((hi-lo)==1){
                mid=hi;
                break;
            }

            mid=lo+(hi-lo)/2;
            if(array[mid]>=array[lo])
                lo=mid;
            else if(array[mid]<=array[hi])
                hi=mid;
        }
        return array[mid];
    }
    public static void main(String[] args) {
        int[] a={3,4,5,1,2};
        System.out.println(minNumberInRotateArray(a));
        //System.out.println(isUniqueChars3("abc"));

    }
}
