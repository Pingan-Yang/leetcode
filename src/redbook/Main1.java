package redbook;


import java.util.*;

/**
 * 在遥远的国度有一位国王，他每天的工作都十分繁忙，
 * 因为每天都有许多大臣来向他汇报各种信息等。这天有n位大臣来汇报信息，其中第i位的序号为i，为了更有效的完成每天的工作，
 * 国王决定给每位大臣汇报的事情按重要性进行一个排序，让各位大臣按排序依次汇报。首先对每人的汇报在m个方面各评估一个重要性，
 * 然后每个汇报的重要性就是m个方面的重要性之和，重要性越高的汇报会排在越前面，对于重要性相同的，则按大臣的序号排序，越小的在越前面。
 * 这时，序号为id的大臣找到了你，他想请你帮他计算一下他排在第几个。
 *
 *
 * 第一行三个正整数n、m和id，表示大臣数量、重要性方面数量和来找你帮忙的大臣序号。
 *
 * 接下来n行每行m个正整数，第i行为ai1, ai2,...... aim，其中aij表示序号为i的大臣的汇报在第j个方面的重要性。
 *
 *
 * 输出一行一个正整数ans，表示序号为i的大臣排在第ans位。
 *
 * 3 3 2
 * 90 90 90
 * 80 100 90
 * 80 85 85
 *
 * 2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] nums=new int[3];
        for (int i=0;i<3;++i){
            nums[i]=Integer.parseInt(sc.next());
        }
        List<HashMap<List<Integer>,Integer>> list=new ArrayList<>();
        for (int i=0;i<nums[0];++i){
            HashMap<List<Integer>,Integer> map=new HashMap();
            List<Integer> data=new ArrayList<>();
            for (int j=0;j<nums[1];++j){
                data.add(Integer.parseInt(sc.next()));
            }
            map.put(new ArrayList<Integer>(data),i+1);
            list.add(new HashMap<List<Integer>,Integer>(map));
        }

        HashMap<List<Integer>, Integer> target = list.get(nums[2]-1);
        Collections.sort(list,(o1, o2) ->{
            Set<List<Integer>> keySet1 = o1.keySet();
            Set<List<Integer>> keySet2 = o2.keySet();
            int sum1=0;
            Iterator<List<Integer>> iterator = keySet1.iterator();
            List<Integer> list1=null;
            while(iterator.hasNext()){
                list1 = iterator.next();
                for (int i=0;i<list1.size();++i){
                    sum1+=list1.get(i);
                }
                break;
            }
            int sum2=0;
            Iterator<List<Integer>> iterator2 = keySet2.iterator();
            List<Integer> list2=null;
            while(iterator2.hasNext()){
                list2 = iterator2.next();
                for (int i=0;i<list2.size();++i){
                    sum2+=list2.get(i);
                }
                break;
            }
            if (sum1!=sum2){
                return sum2-sum1;
            }else{
                return o1.get(list1)-o2.get(list2);
            }

        });


        for (int i=0;i<list.size();++i){
            HashMap<List<Integer>, Integer> listIntegerHashMap = list.get(i);
            if (listIntegerHashMap==target){
                System.out.println(i+1);
                return;
            }
        }

    }
}
