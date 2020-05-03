package leetcode.weeklyContest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/5/3
 * @description: 5400. 旅行终点站
 */
public class DestCity {
    public String destCity(List<List<String>> paths) {
        Set<String> citys = new HashSet<>();
        for (List<String> list : paths) {
            citys.add(list.get(0));
            citys.add(list.get(1));
        }

        for (List<String> list : paths) {
            citys.remove(list.get(0));
        }
        return citys.iterator().next();

    }
}
