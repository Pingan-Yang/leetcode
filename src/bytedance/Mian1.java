package bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mian1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String[] split = sc.nextLine().split(" ");
        for (int i = 0; i < split.length; ++i) {
            list.add(Integer.parseInt(split[i]));
        }
        int sum = Integer.parseInt(sc.next());
        //---------------------------
        process(list, sum);
    }

    private static void process(List<Integer> list, int sum) {
        //判断二叉树是否是是符合要去的二叉树
        if (isTree(list, sum)) {
            System.out.println(true);

        } else {
            System.out.println(false);
        }


        if (sum <= 0) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) == -1) {
                continue;
            }
            if (sum <= 0) {
                break;
            }
            if (list.get(i) >= 0 && list.get(i) < 5) {
                sum -= (5 - list.get(i));
            }
        }

        if (sum <= 0) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }
    }


    /**
     * 1 -1 3 2 0
     * 10
     */
    private static boolean isTree(List<Integer> list, int sum) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) == -1 && 2 * i + 1 < list.size() && list.get(2 * i + 1) != -1) {
                return false;
            } else if (list.get(i) == -1 && 2 * i + 2 < list.size() && list.get(2 * i + 2) != -1) {
                return false;
            }
        }

        return sum >= 0;

//        select s.S, s.Sname, s.Sage, s.Ssex, sc.score
//        from Staff s
//        left join SC sc on s.S=sc.s
//        left join Course c on sc.C=c.C
//        left join Teacher t  on t.T=c.T
//        where t.Tname='Tom'
//        Order by sc.score desc
//        limit 1;

    }
}
