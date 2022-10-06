package keep;

import org.junit.Test;

import java.util.Arrays;

public class Mian2 {
    public int[] process(int[]timeToBed,int[][]clock){
        Arrays.sort(clock,(o1, o2) -> o1[0]-o2[0]);
        int[] data=clock[0];
        if (data[0]==timeToBed[0]&&data[1]==timeToBed[1]){
            return new int[]{0,0};
        }

        if (data[0]>=timeToBed[0]){
            if (data[0]==timeToBed[0]){
                if (data[1]>timeToBed[1]){
                    return new int[]{0,data[1]-timeToBed[0]};
                }else{
                    return new int[]{23,60-(timeToBed[1]-data[1])};
                }
            }else{
                int m=data[0]*60+data[1]-(timeToBed[0]*60+timeToBed[1]);
                return new int[]{m/60,m%60};
            }
        }else{
            int m=24*60-(timeToBed[0]*60+timeToBed[1])+(data[0]*60+data[1]);

            return  new int[]{m/60,m%60};
        }
    }

    @Test
    public void test(){
        int[] timeToBed={23,35};
        int[][]clock={{20,15},{10,30}};
        int[] process = process(timeToBed, clock);
        System.out.println(Arrays.toString(process));
    }
}
