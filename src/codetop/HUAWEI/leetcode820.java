package codetop.HUAWEI;

/**
 * @ClassName leetcode820
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/15 20:09
 * @Version:1.0
 */

import org.junit.Test;
import java.util.Arrays;

/**
 * leetcode 820：单词的压缩编码
 *
 * 单词数组 words的有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足
 *      words.length == indices.length
 *      助记字符串 s 以 '#' 字符结尾
 *      对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 *
 * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 *
 * 示例：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 *
 *
 * 可以想到最后的编码结果肯定是若干个单词之间用#分隔开来的。
 * 示例里的"me"由于是"time"的后缀，所以me这个单词不用出现在最后的编码结果里，
 * 所以我们只要找到单词列表里，哪些单词被别的单词的后缀给包含了就可以了。
 * 这题很明显是用字典树来做的
 *
 * 这类很明显是用字典树去做的题目，明显特征就是需要大量地判断某个字符串是否是给定单词列表中的前缀/后缀。
 * 为什么要说后缀也可以呢？因为把单词倒着插入，就可以搜后缀了~
 *
 */
public class leetcode820 {
    public int minimumLengthEncoding(String[] words) {

        int len=0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words,(s1,s2)-> s2.length()-s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String s:words){
            len+=trie.insert1(s);
        }

        return len;
    }

    @Test
    public void test(){
        String[] words={"time", "me", "bell"};
        int len = minimumLengthEncoding(words);
        System.out.println(len);
    }
}
//实现前缀树

class Trie{
    //前缀树根节点
    TrieNode root;

    public Trie() {
        root=new TrieNode();
    }
    public int insert1(String word){
        if (word==null){
            return 0;
        }
        char[] chars = word.toCharArray();
        TrieNode node=root;

        boolean isNew=false;
        int index=0;
        //此处倒着插入
        for (int i=chars.length-1;i>=0;i--) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
                isNew=true;
            }
            node = node.nexts[index];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        // 加1是#
        return isNew? word.length() + 1: 0;
    }

    public void insert(String word) {
        if (word==null){
            return;
        }
        char[]chs=word.toCharArray();
        TrieNode node=root;
        node.pass++;
        int index=0;
        for (int i=0;i<chs.length;++i){
            index=chs[i]-'a';
            if (node.nexts[index]==null){
                node.nexts[index]=new TrieNode();
            }
            node=node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public boolean search(String word) {
        if (word==null){
            return false;
        }
        char[]chs=word.toCharArray();
        TrieNode node=root;
        int index=0;
        for (int i=0;i<chs.length;++i){
            index=chs[i]-'a';
            if (node.nexts[index]==null){
                return false;
            }
            node=node.nexts[index];
        }
        if (node.end==0){
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        if (prefix==null){
            return false;
        }
        char[] chs=prefix.toCharArray();
        TrieNode node=root;
        int index=0;
        for (int i=0;i<chs.length;++i){
            index=chs[i]-'a';
            if (node.nexts[index]==null){
                return false;
            }
            node=node.nexts[index];
        }
        return true;
    }


}


class TrieNode{
    public int pass; // 经过该字符得字符串的个数
    public int end;  // 以该字符结尾的字符串的个数
    public TrieNode[] nexts; // 经过该字母的后续字母节点


    public TrieNode() {
        pass=0;
        end=0;
        nexts=new TrieNode[26];
    }

}
