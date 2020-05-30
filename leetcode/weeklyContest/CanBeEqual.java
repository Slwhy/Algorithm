package leetcode.weeklyContest;

import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/5/30
 * @description: 5408. 通过翻转子数组使两个数组相等
 */
public class CanBeEqual {
    public boolean canBeEqual(int[] target, int[] arr) {
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        HashMap<Integer, Integer> arrMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            if (!targetMap.keySet().contains(target[i])) {
                targetMap.put(target[i], 1);
            } else targetMap.put(target[i], targetMap.get(target[i]) + 1);
            if (!arrMap.keySet().contains(arr[i])) arrMap.put(arr[i], 1);
            else arrMap.put(arr[i], arrMap.get(arr[i]) + 1);
        }
        for (Integer i : targetMap.keySet()) {
            if (!targetMap.get(i).equals(arrMap.get(i))) return false;
        }
        return true;
    }

}
