package javainthink;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shkstart on 2017/12/10.
 */
public class RegexTest {

    public static void main(String[] args) {
        String str="Java now has regular expressions";
        String[] s={"^Java","s{4}","s?","s+","s*"};
        for (int i = 0; i < s.length; i++) {
            Pattern p=Pattern.compile(s[i]);
            Matcher m=p.matcher(str);
            while (m.find()){
                System.out.println(m.group());
            }
        }

    }
}
