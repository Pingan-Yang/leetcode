package zhongxing;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        int[][] nums = new int[n][2];
        for (int i = 0; i < n; ++i) {
            nums[i][0] = Integer.parseInt(sc.next());
            nums[i][1] = Integer.parseInt(sc.next());
        }
        Arrays.sort(nums, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int ans = 1;
        int preEnd = nums[0][1];
        for (int i = 1; i < n; ++i) {
            int curStart = nums[i][0];
            int curEnd = nums[i][1];
            if (curStart < preEnd) {
                if (curEnd <= preEnd) {
                    continue;
                } else {
                    preEnd = curEnd;
                    ans++;
                }
            } else {
                ans++;
                preEnd = curEnd;
            }
        }
        System.out.println(ans);
    }
}
