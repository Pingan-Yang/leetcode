package offer;

/**
 * @ClassName offer58II
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/15 21:44
 * @Version:1.0
 */
public class offer58II {
    public String reverseLeftWords(String s, int n) {
        String pre=s.substring(0,n);
        String post=s.substring(n);
        return  post+pre;

    }
}
