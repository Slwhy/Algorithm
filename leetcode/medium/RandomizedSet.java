package leetcode.medium;

import java.util.*;

/**
 * @author: slwhy
 * @date: 2020/4/27
 * @description: 380. 常数时间插入、删除和获取随机元素
 */

class Num {
    int val;

    public Num(int n) {
        val = n;
    }
}

public class RandomizedSet {
    /**
     * Initialize your data structure here.
     */

    HashMap<Integer, Num> set;

    ArrayList<Num> list;

    public RandomizedSet() {
        set = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        Num num = new Num(val);
        if (set.keySet().contains(val)) return false;
        else {
            set.put(val, num);
            list.add(num);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (set.keySet().contains(val)) {
            list.remove(set.get(val));
            set.remove(val);
            return true;
        } else return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index).val;
    }

    public static void main(String[] args) {
        LinkedList<Num> tmp = new LinkedList<>();

        Num num = new Num(8);

        for (int i = 0; i < 10; i++) {
            tmp.add(new Num(i));
        }
        tmp.add(num);
        tmp.remove(num);

        for (Num i : tmp) {
            System.out.println(i.val);
        }

    }
}
