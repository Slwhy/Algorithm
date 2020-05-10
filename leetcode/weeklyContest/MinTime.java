package leetcode.weeklyContest;


import java.util.*;

/**
 * @author: slwhy
 * @date: 2020/5/10
 * @description: 5406. 收集树上所有苹果的最少时间
 */

public class MinTime {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (tree.keySet().contains(edges[i][0])) tree.get(edges[i][0]).add(edges[i][1]);
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(edges[i][1]);
                tree.put(edges[i][0], tmp);
            }
        }
        int res = 0;
        for (Integer node : tree.get(0)) {
            res += dfs(tree, node, hasApple);
        }
        return res;
    }

    public int dfs(HashMap<Integer, List<Integer>> tree, int node, List<Boolean> hasApple) {
        if (tree.keySet().contains(node)) {
            int count = 0;
            for (Integer child : tree.get(node)) {
                count += dfs(tree, child, hasApple);
            }
            if (count > 0) return count + 2;
            else if (hasApple.get(node)) return 2;
            else return 0;
        } else if (hasApple.get(node)) return 2;
        else return 0;
    }


    public static void main(String[] args) {
        MinTime minTime = new MinTime();
        int[][] edge = new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 4}};
        List<Boolean> hasApple = new ArrayList<>(Arrays.asList(true, true, false, true, true));

        System.out.println(minTime.minTime(5, edge, hasApple));
    }

}
