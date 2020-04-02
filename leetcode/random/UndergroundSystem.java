package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/3/29
 * @description: 1396. 设计地铁系统
 */

class Trip {
    String start;
    int time;

    public Trip(String station, int t) {
        start = station;
        time = t;
    }

}

public class UndergroundSystem {
    /**
     * @Author slwhy
     * @Date 2020/3/31
     * @Param
     * @return
     * @Description 之前有一个问题，当乘客出站后，要更新  inStation 集合，避免该乘客下次进站时无法更新数据
     **/

    Set<Integer> inStation = new HashSet<>();

    HashMap<Integer, Trip> trips = new HashMap<>();
    HashMap<String, HashMap<String, ArrayList<Integer>>> stationTrip = new HashMap<>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        if (!inStation.contains(id)) {
            inStation.add(id);
            trips.put(id, new Trip(stationName, t));
        }
    }

    public void checkOut(int id, String stationName, int t) {
        if (inStation.contains(id)) {
            inStation.remove(id);
            Trip trip = trips.get(id);
            if (stationTrip.keySet().contains(trip.start)) {
                HashMap<String, ArrayList<Integer>> tmp = stationTrip.get(trip.start);
                if (tmp.keySet().contains(stationName)) {
                    tmp.get(stationName).add(t - trip.time);
                } else {
                    ArrayList array = new ArrayList();
                    array.add(t - trip.time);
                    tmp.put(stationName, array);
                }
            } else {
                ArrayList array = new ArrayList();
                array.add(t - trip.time);
                HashMap<String, ArrayList<Integer>> tmp = new HashMap<String, ArrayList<Integer>>();
                tmp.put(stationName, array);
                stationTrip.put(trip.start, tmp);
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        if (stationTrip.keySet().contains(startStation)) {
            HashMap<String, ArrayList<Integer>> tmp = stationTrip.get(startStation);
            if (tmp.keySet().contains(endStation)) {
                int sum = 0;
                for (Integer i : tmp.get(endStation)) {
                    sum += i;
                }
                return (double) sum / tmp.get(endStation).size();
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        UndergroundSystem system = new UndergroundSystem();
        system.checkIn(1, "beijin", 8);
        system.checkIn(2, "beijin", 9);
        system.checkOut(1, "shanghai", 10);
        system.checkIn(1, "beijin", 12);
        system.checkOut(2, "shanghai", 11);
        system.checkOut(1, "shanghai", 15);
        System.out.println(system.getAverageTime("beijin", "shanghai"));
    }
}
