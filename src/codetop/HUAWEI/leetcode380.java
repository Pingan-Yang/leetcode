package codetop.HUAWEI;

/**
 * @ClassName leetcode380
 * @Description: TODO
 * @Author 15368
 * @Date 2022/7/14 20:18
 * @Version:1.0
 */

import java.util.*;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 *
 * 实现RandomizedSet 类：
 *
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 *
 *  
 *
 */
public class leetcode380 {
}

/**
 * 变长数组可以在 O(1) 的时间内完成获取随机元素操作，但是由于无法在 O(1)的时间内判断元素是否存在，因此不能在 O(1)的时间内完成插入和删除操作。
 * 哈希表可以在 O(1) 的时间内完成插入和删除操作，但是由于无法根据下标定位到特定元素，因此不能在 O(1) 的时间内完成获取随机元素操作。
 * 为了满足插入、删除和获取随机元素操作的时间复杂度都是 O(1) 需要将变长数组和哈希表结合，变长数组中存储元素，哈希表中存储每个元素在变长数组中的下标。
 *
 * 插入操作时，首先判断 val 是否在哈希表中，如果已经存在则返回 false，如果不存在则插入 val，
 * 删除操作时，首先判断val 是否在哈希表中，如果不存在则返回 false，如果存在则删除 val
 *
 * 除操作的重点在于将变长数组的最后一个元素移动到待删除元素的下标处，然后删除变长数组的最后一个元素。该操作的时间复杂度是 O(1)，
 * 且可以保证在删除操作之后变长数组中的所有元素的下标都连续，方便插入操作和获取随机元素操作。
 *
 * 获取随机元素操作时，由于变长数组中的所有元素的下标都连续，因此随机选取一个下标，返回变长数组中该下标处的元素。

 *

 *
 */

class RandomizedSet {
    List<Integer> nums;
    Map<Integer,Integer>indices;
    Random random;
    public RandomizedSet() {
        nums=new ArrayList<>();
        indices=new HashMap<>();
        random=new Random();
    }

    public boolean insert(int val) {
        if (indices.containsKey(val)){
            return false;
        }

        int index=nums.size();
        nums.add(val);
        indices.put(val,index);
        return true;
    }

    public boolean remove(int val) {
        if (!indices.containsKey(val)){
            return false;
        }
        int index=indices.get(val);
        int last=nums.get(nums.size()-1);
        nums.set(index, last);
        indices.put(last,index);
        nums.remove(nums.size()-1);
        indices.remove(val);
        return true;

    }

    public int getRandom() {
        int randomIndex = random.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}
