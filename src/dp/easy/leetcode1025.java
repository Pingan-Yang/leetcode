package dp.easy;

/**
 * @ClassName leetcode1025
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/9 16:17
 * @Version:1.0
 */

/**
 *爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
 */
public class leetcode1025 {
    /**
     *数学模拟：
     *      n=1        爱丽丝先手 输
     *      n=2        爱丽丝拿1  赢
     *      n=3        爱丽丝拿1-->n=2 鲍勃赢
     *      n=4        爱丽丝拿1or2-->  爱丽丝拿1 n=3 爱丽丝赢
     *      n=5 的时候，爱丽丝只能拿 1，根据 n = 4，Alice 会输
     *
     *
     *     结论：n 为奇数的时候 Alice（先手）必败，n 为偶数的时候 Alice 必胜。
     *
     *
     */
    public boolean divisorGame(int n) {

        return n%2==0;
    }

    /**
     * Alice 处在 n = k的状态时，他（她）做一步操作，必然使得 Bob 处于 n = m (m < k)的状态。
     * 因此我们只要看是否存在一个 m 是必败的状态，那么 Alice 直接执行对应的操作让当前的数字变成 m，Alice 就必胜了，
     * 如果没有任何一个是必败的状态的话，说明 Alice 无论怎么进行操作，最后都会让Bob 处于必胜的状态，此时 Alice 是必败的
     *
     *
     * 定义 f[i]表示当前数字 i 的时候先手是处于必胜态还是必败态，
     * true 表示先手必胜，false 表示先手必败
     */
    public boolean divisorGame2(int n) {
        boolean[] f = new boolean[n + 5];

        f[1] = false;
        f[2] = true;
        for (int i = 3; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                if ((i % j) == 0 && !f[i - j]) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];
    }

}
