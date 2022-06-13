package codetop.HUAWEI;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName leetcode554
 * @Description: TODO
 * @Author 15368
 * @Date 2022/6/13 20:51
 * @Version:1.0
 */

/**
 * 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。
 * 这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
 * <p>
 * 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。
 * 如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。
 * 你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的
 * <p>
 * <p>
 * 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。
 * 其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。
 * 你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
 */
public class leetcode554 {
    //暴力解法
    public int leastBricks1(List<List<Integer>> wall) {

        List<List<Integer>> wallStartPoint = new ArrayList<>();
        List<Integer> sum = new ArrayList<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        int temp = 0;
        for (int i=0;i<wall.size();++i){
            for (int j=0;j<wall.get(i).size()-1;++j){
                temp+=wall.get(i).get(j);
                sum.add(temp);
                if (!map.containsKey(temp)){
                    map.put(temp,1);
                }else{
                    map.put(temp,map.get(temp)+1);
                }
            }
            wallStartPoint.add(new ArrayList<>(sum));
            sum.clear();
            temp=0;
        }

        //找到出现次数最多的起点
        int maxCount=0;
        int start=0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>maxCount){
                maxCount=entry.getValue();
                start=entry.getKey();
            }
        }

        //找到不含有最多起点的墙面的个数 就是答案
        int ans=0;
        for (int i=0;i<wallStartPoint.size();++i){
           if (!wallStartPoint.get(i).contains(start)){
               ans++;
           }
        }
        return ans;
    }

    //优化
    public int leastBricks(List<List<Integer>> wall){
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;

    }

    @Test
    public void test(){
        List<List<Integer>>wall=new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));
        int bricks = leastBricks(wall);
        System.out.println(bricks);
    }
}
