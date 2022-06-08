package offer;

/**
 * @ClassName offer19
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/19 21:03
 * @Version:1.0
 */
public class offer19 {
    public boolean isMatch(String s, String p) {
        /**
         * dp
         * f(i,j)表示 s的前i个字符与p的前j个字符是否匹配
         * p[j]≠'*'
         *      f(i,j)=f(i-1.j-1)&&(i,j匹配)
         * p[j]=='*'
         *
         *      f(i,j)=f(i,j-2)||f(i-1,j-2)||f(i-2,j-2)||f(i-3,j-2)...||f(i-k,j-2) (匹配0~k个，连续k个相同的)
         *
         *      f(i-1,j)=f(i-1,j-2)||f(i-2,j-2)||f(i-3,j-2)...||f(i-1-(k-1),j-2) (连续匹配k-1个相同的)
         *
         *   ==>
         *      f(i-1,j)=f(i-1,j-2)||f(i-2,j-2)||f(i-3,j-2)...||f(i-k,j-2)(连续k-1个相同)
         *       f(i,j)=f(i,j-2)||f(i-1,j)
         *====================================================================================================
         *      f(i,j)=f(i,j-2)||f(i-1,j-2)&&(i,j-1匹配)||f(i-2,j-2)&&(i-1,j-1匹配)...
         *      f(i-1,j)=f(i-1,j-2)||f(i-2,j-2)&&(i-1,j-1匹配)||f(i-3,j-2)&&(i-2,j-1匹配)
         *
         *      f(i,j)=f(i,j-2)||f(i-1,j)&&(i,j-1)
         */

        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        //s从0开始遍历  因为 "" 与".*"匹配
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    // 匹配0个
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        //匹配0个或多个
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }
    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

}
