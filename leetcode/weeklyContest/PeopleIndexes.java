package leetcode.weeklyContest;

import java.util.*;

/**
 * @author: slwhy
 * @date: 2020/5/17
 * @description: 5414. 收藏清单
 */
public class PeopleIndexes {


    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        HashMap<String, Set<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (String company : favoriteCompanies.get(i)) {
                if (map.keySet().contains(company)) {
                    map.get(company).add(i);
                } else {
                    Set<Integer> peoples = new HashSet<>();
                    peoples.add(i);
                    map.put(company, peoples);
                }
            }
        }
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            Set<Integer> tmp = new HashSet<>(map.get(favoriteCompanies.get(i).get(0)));
            for (String company : favoriteCompanies.get(i)) {
                tmp.retainAll(map.get(company));
            }
            if (tmp.size() == 1) {
                res.add(i);
            }
        }

        return res;
    }
}
