package leetcode.random;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: slwhy
 * @date: 2020/5/29
 * @description: 1353. 最多可以参加的会议数目
 */
public class MaxEvents {

    public int maxEvents(int[][] events) {
        /**
         * @Author slwhy
         * @Date 2020/5/29
         * @Param [events]
         * @return int
         * @Description leetcode 上的解法
         **/
        Arrays.sort(events, (o1, o2) -> o1[0] - o2[0]);
        //小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //结果、开始时间、events下标、有多少组数据
        int res = 0, last = 1, i = 0, n = events.length;
        while (i < n || !pq.isEmpty()) {
            //将start相同的会议都放进堆里
            while (i < n && events[i][0] == last) {
                pq.offer(events[i++][1]);
            }
            //pop掉当前天数之前的
            while (!pq.isEmpty() && pq.peek() < last) {
                pq.poll();
            }
            //顶上的就是俺们要参加的
            if (!pq.isEmpty()) {
                pq.poll();
                res++;
            }
            last++;
        }
        return res;
    }

    public int maxEvents1(int[][] events) {
        /**
         * @Author slwhy
         * @Date 2020/5/29
         * @Param [events]
         * @return int
         * @Description 暴力，时间过不了
         **/

        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] flag = new int[events[events.length - 1][1] + 1];
        int res = 0;

        for (int i = 0; i < events.length; i++) {
            for (int j = events[i][0]; j <= events[i][1]; j++) {
                if (flag[j] == 0) {
                    flag[j] = 1;
                    res++;
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxEvents maxEvents = new MaxEvents();
        System.out.println(maxEvents.maxEvents(new int[][]{{1, 5}, {1, 5}, {1, 5}, {2, 3}, {2, 3}}));
    }

}
