package hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName leetcode3
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/29 11:03
 * @Version:1.0
 */
public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        Set<Character> set=new HashSet<>();
        //利用滑动窗口的思想
        //左指针指向滑动窗口的左边界
        char[] chs=  s.toCharArray();
        int n=chs.length;
        int right=-1;//初始时  右边界在左边界的左边
        int ans=0;
        for(int left=0;left<n;++left){
            if(left!=0){
                //移除上一次的左边界  则证明 以该点作为起始点的最大无重复字串已经遍历完成
                set.remove(chs[left-1]);
            }

            while(right+1<n&&!set.contains(chs[right+1])){
                //只要没找到重复的 右指针就一直右移
                set.add(chs[right+1]);
                right++;
            }

            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }

}
