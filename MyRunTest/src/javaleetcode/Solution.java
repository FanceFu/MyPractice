package javaleetcode;

import com.sun.javafx.sg.prism.web.NGWebView;
import sun.reflect.generics.tree.Tree;

/**
 * Created by shkstart on 2017/12/10.
 */
public class Solution {

    /**
     * 657. Judge Route Circle
     * @param moves
     * @return
     */
    public static boolean judgeCircle(String moves) {
        if(moves==null) return true;
        int R=0,L=0,U=0,D=0;
        for (int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i)=='R')
                R++;
            if(moves.charAt(i)=='L')
                L++;
            if(moves.charAt(i)=='U')
                U++;
            if(moves.charAt(i)=='D')
                D++;
        }
        return R==L&&U==D;
    }


    /**
     * 557. Reverse Words in a String III
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        if(s==null)return null;
        StringBuilder res=new StringBuilder();
        String[] str=s.split(" ");
        for (int i = 0; i <str.length ; i++) {
            StringBuilder sb=new StringBuilder(str[i]);
            sb=sb.reverse();
            res.append(sb);
            res.append(" ");
        }

        return res.toString().trim();
    }

    /**
     * 500. Keyboard Row
     * @param words
     * @return
     */
    public static String[] findWords(String[] words) {
        if(words==null||words.length<=0) return words;
        String res= new String();
        for (int i = 0; i <words.length ; i++) {
            if(isKeyBoardRow(words[i].toUpperCase())){
                res+=words[i]+" ";

            }
        }
        return res.trim().split(" ");
    }
    public static boolean isKeyBoardRow(String str){
        String row1="QWERTYUIOP";
        String row2="ASDFGHJKL";
        String row3="ZXCVBNM";
        int r1=findLine(str,row1);
        int r2=findLine(str,row2);
        int r3=findLine(str,row3);
        if(r1==1||r2==1||r3==1)
         return true;

        return false;
    }

    public static int findLine(String strSon,String str){
        for (int i = 0; i <strSon.length() ; i++) {
            if(str.indexOf(strSon.charAt(i))<0)
                return 0;
        }
        return 1;
    }


    /**
     * 344. Reverse String
     * @param s
     * @return
     */
    public String reverseString(String s) {
        if(s==null) return null;
        StringBuilder sb =new StringBuilder(s);
        return sb.reverse().toString();
    }


    /**
     * 476. Number Complement
     * @param num
     * @return
     */
    public static int findComplement(int num) {
        return ~num&(Integer.highestOneBit(num)-1);
    }



    /**
     * 283. Move Zeroes  将非0数字前移知道前一个非0数字 或数组头
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i <nums.length; i++) {

            if(nums[i]!=0){
                for (int j = i-1; j >=0 ; j--) {
                    if(nums[j]==0){
                        int tmp=nums[j];
                        nums[j]=nums[j+1];
                        nums[j+1]=tmp;
                    }else break;
                }

            }
        }
    }

    /**
     * 371. Sum of Two Integers  不允许用+ -求和
     * @param a
     * @param b
     * @return
     */
    public static int getSum(int a, int b) {
        if(a==0)return b;
        if(b==0) return a;

        while (b!=0){
            int carry=a&b;
            a=a^b;
            b=carry<<1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(getSum(1,2));
       // int[] a={0,0,1};
      //  moveZeroes(a);
       // for (int tmp:a
       //      ) {
        //    System.out.println(tmp);
        //}
       // String moves= "LL";
       // System.out.println(judgeCircle(moves));
       // String s="Let's take LeetCode contest";
       // System.out.println(reverseWords(s));
        //String[] words={"Hello", "Alaska", "Dad", "Peace"};
       // String[] res=findWords(words);
        //for (String tmp:res
        //     ) {
        //    System.out.println(tmp);
       // }
        //System.out.println(findComplement(5));
    }
}
