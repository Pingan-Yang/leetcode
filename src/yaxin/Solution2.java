package yaxin;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int cal (int N, int m) {
        // write code here
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i+1);
        }
        int cur=-1;
        for (int i = 0; i < N - 1; i++) {
            cur+=m;
            cur%=N-i;
            list.remove(cur);
            cur--;
        }
        return list.get(0);
    }
}
