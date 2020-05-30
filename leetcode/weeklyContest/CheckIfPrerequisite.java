package leetcode.weeklyContest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/5/30
 * @description: 5410. 课程安排 IV
 */
public class CheckIfPrerequisite {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.keySet().contains(prerequisites[i][0])) map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            else {
                HashSet<Integer> tmp = new HashSet<>();
                tmp.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], tmp);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.keySet().contains(i)) {
                int lent = 0;
                while (lent != map.get(i).size()) {
                    lent = map.get(i).size();
                    HashSet<Integer> preS = new HashSet<>();
                    preS.addAll(map.get(i));
                    for (Integer pre : preS) {
                        if (map.keySet().contains(pre)) map.get(i).addAll(map.get(pre));
                    }
                }
            }
        }

        List<Boolean> res = new ArrayList<>();

        for (int[] couple : queries) {
            if (map.keySet().contains(couple[0])) res.add(map.get(couple[0]).contains(couple[1]));
            else res.add(false);
        }

        return res;
    }

    public static void main(String[] args) {
        CheckIfPrerequisite checkIfPrerequisite = new CheckIfPrerequisite();
        int[][] pre = new int[][] {{2,3},{2,1},{2,0},{3,4},{3,6},{5,1},{5,0},{1,4},{1,0},{4,0},{0,6}};
        int[][] qury = new int[][] {{3,0},{6,4},{5,6},{2,6},{2,3},{5,6},{4,0},{2,6},{3,5},{5,3},{1,6},{1,0},{3,5},{6,5},{2,3},{3,0},{3,4},{3,4},{2,5},{0,3},{4,0},{6,4},{5,0},{6,5},{5,6},{6,5},{1,0},{3,4},{1,5},{1,4},{3,6},{0,1},{1,2},{5,1},{5,3},{5,3},{3,4},{5,4},{5,4},{5,3}};
        checkIfPrerequisite.checkIfPrerequisite(7,pre,qury);
    }

}
