package offer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName offer38
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/11 22:14
 * @Version:1.0
 */
public class offer38 {
    List<String> rec;
    boolean[] vis;
    StringBuilder sb = new StringBuilder();

    public String[] permutation(String s) {
        rec=new ArrayList<>();
        int n = s.length();
        vis = new boolean[n];
        char[] chars = s.toCharArray();
        //对数组排序，使得重复的字符排列在一起，方便去重
        Arrays.sort(chars);
        dfs(chars, 0, n);

        String[] res = new String[rec.size()];
        for (int i = 0; i < rec.size(); ++i) {
            res[i] = rec.get(i);
        }
        return res;
    }

    private void dfs(char[] chars, int index, int n) {
        if (index == n) {
            rec.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; ++i) {
            //去重，保证每个位置重复的字母只填进去一次
            //我们限制每次填入的字符一定是这个字符所在重复字符集合中「从左往右第一个未被填入的字符」
            if (vis[i] || (i > 0 && !vis[i - 1] && chars[i - 1] == chars[i])) {
                continue;
            }
            vis[i] = true;
            sb.append(chars[i]);
            dfs(chars, index + 1, n);
            sb.deleteCharAt(sb.length() - 1);
            vis[i] = false;
        }
    }


    @Test
    public void test() {
        String s = "aaab";
        String[] strings = permutation(s);
        System.out.println(Arrays.toString(strings));
    }
}
