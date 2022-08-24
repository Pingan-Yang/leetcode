package rongyao;

import java.util.*;

/**
 * @ClassName Main1
 * @Description: TODO
 * @Author 15368
 * @Date 2022/8/20 18:06
 * @Version:1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        String str=sc.next();
      // Map<Integer,String> indexMap=new HashMap<>();
        List<String> ans=new ArrayList<>();
        int len=str.length();

        int index=0;
        while (true){
            if (str.charAt(index)=='0'){
                ans.add(new StringBuilder(str.substring(index+1,index+9)).reverse().toString());
                index+=9;
            }
            if (str.charAt(index)=='1'){
                ans.add(str.substring(index+1,index+9));
                index+=9;
            }
            if (index>=len){
                break;
            }
        }


        for (int i=0;i<ans.size();++i){
            System.out.print(ans.get(i));
            if (i!=ans.size()-1){
                System.out.print(" ");
            }
        }

    }
}
