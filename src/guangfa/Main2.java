package guangfa;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2 {
    public String printEmail(String str) {
        // write code here
        //String regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
        String regex ="[0-9a-zA-Z_]+[0-9a-zA-Z_.-]*@([a-zA-Z]{2,})+(.[a-zA-Z]{2,})+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        boolean flag = true;

        while (matcher.find()) {
            if (flag){
                sb.append("true ");
                flag=false;
            }
            String group = matcher.group();
            sb.append(group + " ");
        }
        if (sb.length()!=0) {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (flag){
            sb.delete(0,sb.length());
            sb.append("false");
        }

        // sb.append("false");


        return sb.toString();
    }

    @Test
    public void test() {
        String s = "true _test@qq.com ha-ha.wang@SINA.COM.CN";
        String ans = printEmail(s);
        System.out.println(ans);
    }
}
