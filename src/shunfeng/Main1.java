package shunfeng;


import java.util.Scanner;

/**
 * 小明有一个由1到n的整数组成的排列，他让你来猜出这个排列是什么。
 * 你每次可以猜测某一位置的数字，小明会告诉你所猜测的数是“大了”、“小了”或是“正确”。
 * 你想知道你在最坏情况下，需要猜测几次，才能在排列的所有位置都得到小明“正确”的回复？
 *
 * 输入一个整数n(1≤n≤109)，表示是由[1,n]中的整数组成的排列。
 *
 * 输出一个整数S，表示你在最坏情况下需要猜测S次。
 *
 * 5
 *
 * 11
 *
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());

        System.out.println((n)*(n-1)/2+1);
    }
}
