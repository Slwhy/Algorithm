package leetcode.weeklyContest;

import java.util.ArrayList;


/**
 * @author: slwhy
 * @date: 2020/4/12
 * @description: 1409. 查询带键的排列
 */
public class ProcessQueries {
    public int[] processQueries(int[] queries, int m) {
        int[] res = new int[queries.length];
        ArrayList<Integer> p = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            p.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < p.size(); j++) {
                if (p.get(j).equals(queries[i])) {
                    res[i] = j;
                    p.remove(j);
                    p.add(0, queries[i]);
                    break;
                }
            }
        }
        return res;
    }
}
