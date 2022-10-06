package qunale;
public class Main3 {
    public String showDown(String inhand) {
        String[] split = inhand.split(" ");
        int n = split.length;
        //判断花色
        Character[] huase = new Character[n];
        Character[] nums = new Character[n];
        for (int i = 0; i < n; i++) {
            huase[i] = split[i].charAt(0);
            nums[i] = split[i].charAt(1);
        }

        //判断花色
        int i = 1;
        boolean flag = true;
        while (i < n) {
            if (!huase[i - 1].equals(huase[i])) {
                flag = false;
                break;
            }
            i++;
        }

        return null;
    }
}
