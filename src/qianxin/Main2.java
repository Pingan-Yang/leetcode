package qianxin;

import java.util.*;

public class Main2 {

   static   List<String> ans=new ArrayList<>();
   static   StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.next());
        List<String> ans=letterCombinations(n+"");
        //System.out.println(ans);

        for (int i=0;i<ans.size();++i){
            if (i==0){
                System.out.print("['"+ans.get(i)+"',");
                continue;
            } else  if (i==ans.size()-1){
                System.out.print("'"+ans.get(i)+"']");
                break;
            }else{
                System.out.print("'"+ans.get(i)+"',");
            }
        }



    }


    public  static List<String> letterCombinations(String digits) {
        Map<Character,String> map=new HashMap<>();
        map.put('1',"abc");
        map.put('2',"def");
        map.put('3',"ghi");
        map.put('4',"jkl");
        map.put('5',"mno");
        map.put('6',"pqr");
        map.put('7',"stu");
        map.put('8',"vwx");
        map.put('9',"yz");

        if (digits==null||digits.length()==0){
            return ans;
        }

        dfs(map,digits,0);

        return ans;

    }

    private static void dfs(Map<Character,String>map,String digits,int start){
        if(start==digits.length()){
            ans.add(sb.toString());
            return;
        }

        String s=map.get(digits.charAt(start));
        for(int i=0;i<s.length();++i){
            sb.append(s.charAt(i));
            dfs(map,digits,start+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
