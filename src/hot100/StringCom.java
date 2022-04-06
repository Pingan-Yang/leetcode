package hot100;

import jdk.nashorn.internal.runtime.ListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName StringCom
 * @Description: TODO
 * @Author 15368
 * @Date 2022/3/18 22:21
 * @Version:1.0
 */
public class StringCom  {

    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("aadcx");
        list.add("abcvsd");
        list.add("dbcfs");
        list.add("kdsd");
        list.add("saasa");

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println(list);

    }
}


