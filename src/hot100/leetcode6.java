package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode6
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/30 20:13
 * @Version:1.0
 */
public class leetcode6 {
    public String convert(String s, int numRows) {

        if (numRows<2){
            return s;
        }
        List<StringBuilder> rows=new ArrayList<>();
        for (int i=0;i<numRows;++i){
            rows.add(new StringBuilder());
        }
        int i=0;
        int flag=-1;
        for (char c:s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag; //在达到 ZZ 字形转折点时，执行反向。
            }
            i += flag;
        }
            StringBuilder res=new StringBuilder();
            for (StringBuilder row:rows){
                res.append(row);
            }
            return res.toString();
    }
}
