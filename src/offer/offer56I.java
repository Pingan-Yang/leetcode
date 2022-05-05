package offer;

/**
 * @ClassName offer56I
 * @Description: TODO
 * @Author 15368
 * @Date 2022/5/5 10:26
 * @Version:1.0
 */
public class offer56I {
    public int[] singleNumbers(int[] nums) {
        //利用位运算
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
        }
        // res为只出现一次的两个数之和
        // 因为x,y为两个只出现一次的数那么x和y必定其中有一位不同（一个是0一个是1），
        // 那么将nums拆分为  只包含x 和只包含y的两部分

        //确定首次出现不同数位,即res中第一个等于1的位
        int m = 1;

        while ((res & m) == 0) {
            m <<= 1;
        }

        int x = 0;
        int y = 0;
        for (int num : nums) {
            if ((num&m)!=0){//x 表示该位为1的集合
                x^=num;
            }else{// 表示该位位0的集合
                y^=num;
            }
        }

        return new int[]{x,y};


    }
}
