package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/4/13
 * @description: 56. 合并区间
 */
public class Merge {

    public int[][] merge1(int[][] intervals) {
        /**
         * @Author slwhy
         * @Date 2020/4/14
         * @Param [intervals]
         * @return int[][]
         * @Description leetcode 上的解法
         **/
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] merge = new int[intervals.length][];
        int length = 0;
        for (int[] pair : intervals) {
            if (length == 0 || merge[length - 1][1] < pair[0])
                merge[length++] = pair;
            else
                merge[length - 1][1] = Math.max(merge[length - 1][1], pair[1]);
        }
        int[][] res = new int[length][];
        System.arraycopy(merge, 0, res, 0, length);
        return res;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 1) return new int[0][];
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            if (!map.keySet().contains(starts[i])) {
                map.put(starts[i], intervals[i][1]);
            } else {
                if (map.get(intervals[i][0]) < intervals[i][1]) {
                    map.put(intervals[i][0], intervals[i][1]);
                }
            }
        }
        Arrays.sort(starts);
        ArrayList<int[]> tmp = new ArrayList<>();
        int start = starts[0];
        int end = map.get(start);
        for (int i = 1; i < starts.length; i++) {
            if (starts[i] >= start && starts[i] <= end) {
                if (end < map.get(starts[i])) end = map.get(starts[i]);
            } else {
                int[] inter = new int[2];
                inter[0] = start;
                inter[1] = end;
                tmp.add(inter);
                start = starts[i];
                end = map.get(start);
            }
        }
        tmp.add(new int[]{start, end});
        int[][] res = new int[tmp.size()][2];
        int index = 0;
        for (int[] itme : tmp) {
            res[index++] = itme;
        }
        return res;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] inter = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge.merge(inter);
    }
}
