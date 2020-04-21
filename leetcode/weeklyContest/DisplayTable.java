package leetcode.weeklyContest;


import java.util.*;

/**
 * @author: slwhy
 * @date: 2020/4/19
 * @description: 5389. 点菜展示表
 */
public class DisplayTable {
    public List<List<String>> displayTable(List<List<String>> orders) {
        ArrayList<String> foods = new ArrayList<>();
        Set<String> foodSet = new HashSet<String>();
        ArrayList<Integer> tables = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        String foodItem;
        String table;
        for (int i = 0; i < orders.size(); i++) {
            foodItem = orders.get(i).get(2);
            table = orders.get(i).get(1);
            if (!foodSet.contains(foodItem)) {
                foods.add(foodItem);
                foodSet.add(foodItem);
            }
            if (!map.keySet().contains(table)) {
                tables.add(Integer.valueOf(table));
                HashMap<String, Integer> tmp = new HashMap<>();
                tmp.put(foodItem, 1);
                map.put(table, tmp);
            } else {
                if (map.get(table).keySet().contains(foodItem)) {
                    map.get(table).put(foodItem, map.get(table).get(foodItem) + 1);
                } else map.get(table).put(foodItem, 1);
            }
        }
        Collections.sort(foods);
        Collections.sort(tables);
        for (int i = 0; i < tables.size(); i++) {
            if (i == 0) {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add("Table");
                tmp.addAll(foods);
                res.add(tmp);
            }
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add(String.valueOf(tables.get(i)));
            for (int j = 0; j < foods.size(); j++) {
                if (map.get(tmp.get(0)).keySet().contains(foods.get(j))) {
                    Integer count = map.get(tmp.get(0)).get(foods.get(j));
                    tmp.add(count.toString());
                } else tmp.add("0");
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        DisplayTable displayTable = new DisplayTable();
        String[][] order = new String[][]{{"David", "3", "Ceviche"}, {"Corina", "10", "Beef Burrito"}, {"David", "3", "Fried Chicken"}, {"Carla", "5", "Water"}, {"Carla", "5", "Ceviche"}, {"Rous", "3", "Ceviche"}};
        List<List<String>> orders = new ArrayList<>();
        for (int i = 0; i < order.length; i++) {
            ArrayList<String> tmp = new ArrayList<>();
            for (int j = 0; j < order[i].length; j++) {
                tmp.add(order[i][j]);
            }
            orders.add(tmp);
        }
        displayTable.displayTable(orders);
    }
}
