package offer;

/**
 * @ClassName offer64
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/3 19:51
 * @Version:1.0
 */
public class offer64 {
    //短路&&
    int res=0;
    public int sumNums(int n) {
        boolean x=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
