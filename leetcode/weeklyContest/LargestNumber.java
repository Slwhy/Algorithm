package leetcode.weeklyContest;


import java.util.Arrays;
import java.util.HashMap;


/**
 * @author: slwhy
 * @date: 2020/5/16
 * @description: //todo
 */
public class LargestNumber {
    public int max = 0;
    public String path = "";

    public String largestNumber(int[] cost, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            map.put(cost[i], i + 1);
        }

        int[] array = Arrays.copyOf(cost, cost.length);
        return "";

    }


}
