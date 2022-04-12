package hot100;

/**
 * @ClassName leetcode96
 * @Description: TODO
 * @Author 15368
 * @Date 2022/4/12 21:57
 * @Version:1.0
 */
public class leetcode96 {
    public int numTrees(int n) {
        // 二叉搜索树：左子节点的值<根节点<右子节点的值  子树也成立

        //ans=左子树是不同二叉搜索树的种类+右子树是不同二叉搜索树的种类

        // G(n):表示存在n个节点的二叉搜索树的个数
        // f(i):表示以i为根节点的二叉搜索树的个数

        // G(n)=f(1)+f(2)+...+f(n)
        // f(i)=G(i-1)*G(n-i)
        // 由上面两个推出
        // G(n)=G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)

        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;++i){
            for (int j=1;j<=i;++j){
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];

    }
}
