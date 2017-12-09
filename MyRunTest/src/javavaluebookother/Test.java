package javavaluebookother;

/**
 * Created by shkstart on 2017/12/9.
 */
public class Test {
    /**
     *消除 嵌套括号。
     * @param s
     * @return
     */

    public static String changStr(String s){
        String res="(";
        char[] ch=s.toCharArray();
        int bracketNum=0;
        int i=0;
        while (i<ch.length){
            if(ch[i]=='('){
                bracketNum++;
            }else if(ch[i]==')'){
                if (bracketNum>0)
                    bracketNum--;
                else {
                    System.out.println("error expression");
                    return null;
                }
            }else if(ch[i]==','){
                res+=ch[i++];
                continue;
            }else if (ch[i]>='0'&&ch[i]<='9'){
                res+=ch[i];
            }else {
                System.out.println("error expression");
                return null;
            }
            i++;
        }
        if(bracketNum>0){
            System.out.println("error expression");
            return null;
        }
        res+=")";
        return res;
    }

    /**
     * 不用比较运算  比较两个数 将ab 转换为长整型运算可以防止溢出
     * @return
     */
    public static int max(int  a,int b){
        return (int)(((long)a+(long)b+Math.abs((long)a-(long)b))/2);
    }
    public static int min(int  a,int b){
        return (int)(((long)a+(long)b-Math.abs((long)a-(long)b))/2);
    }

    public static void main(String[] args) {
        System.out.println(max(3,5));
        System.out.println(min(3,5));
       String str="(1,(2,3),(4,(5,6),7))";
        System.out.println(changStr(str));
    }
}
