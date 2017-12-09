package javavaluebookstring;

import javax.swing.text.html.HTMLDocument;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by shkstart on 2017/11/12.
 */
public class Test {

    public static String reverseStr(String str){
        if (str==null)return null;
        StringBuilder sb=new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }


    /**
     * 两个字符串 字符 和个数 是否完全相等  1.排序法  o(nlgn) 2.申请一个数组 遍历
     * str1一遍记下字符位置， 遍历str2  字符位置--  如果数组中 存在不为0的值 则不相等
     * @return
     */
    public static boolean compare(String s1,String s2){
        if(s1==null||s2==null) return false;
        char[] cs1=s1.toCharArray();
        char[] cs2=s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        String res1=new String(cs1);
        String res2=new String(cs2);
        return res1.equals(res2);
    }

    /**
     * 删除字符串重复的字符 2.哈希表 1.暴力搜索 3.正则表达式法
     * @param str
     * @return
     */
    public static String removeDup2(String str){
        StringBuilder sb=new StringBuilder();
        HashSet<Character> set=new HashSet<>();
        for (int i = 0; i < str.length() ;i++) {
            set.add(str.charAt(i));
        }
        Iterator iter=set.iterator();
        while (iter.hasNext()){
            sb.append(iter.next());
        }
        return sb.toString();
    }

    public static String removeDup3(String str){
        str=str.replaceAll("(?s)(.)(?=.*\\1)","");
        return str;
    }

    /**
     * 统计一行字符中有多少个单词  以空格 区分 1.系统函数貌似不能 处理中间多个空格的情况
     * 2. 前面出现空格 当前不为空格 表示一个单词的开始 ，
     * @return
     */
    public  static  int wordCount(String str){
       /*str= str.trim();
       String[] res=str.split(" ");
       return res.length;*/
       int word=0;
       int count=0;
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)==' ')
                word=0;
            else if(word==0){
                word=1;
                count++;
            }
        }

       return count;
    }




    /**
     * 字符串中所有字符都不相同， 输出所有组合  1.暴力递归
     * 2.由于没有重复  可以构造长度为n的 01串  有1代表取该位的字符
     */
    public static void combineImp(String str){
        if(str==null) return;
        char[] tmp=str.toCharArray();

        int n=tmp.length;
        char[] cache=new char[n];
        boolean[] used=new boolean[n];
        int res=n;
        while (true){

            int index=0;
            while (used[index]){
                used[index]=false;
                ++res;
                if(++index==n)
                    return;
            }
            used[index]=true;
            cache[--res]=tmp[index];
            System.out.print(new String(cache).substring(res)+" ");
        }
    }
    public static void main(String[] args) {
        String str1="abc";
        String str2="ba";
        combineImp(str1);
       // System.out.println(wordCount(str1));
        //System.out.println(removeDup2(str1));
        //System.out.println(removeDup3(str1));
        //System.out.println(compare(str1,str2));
        //System.out.println(reverseStr(str));
    }
}
