package leetcode.medium;


import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/5/14
 * @description: 621. 任务调度器
 */
public class LeastInterval {

    public int leastInterval(char[] tasks, int n) {
        /**
         * @Author slwhy
         * @Date 2020/5/14
         * @Param [tasks, n]
         * @return int
         * @Description leetcode 上的解法,基于数学的方法
         * 假设一类任务的最大量为max，所有任务中任务量等于max的任务种类数为 count，所有任务总量为total
         * 那么 耗时 = (max - 1) * (n + 1) + count  和 total的最大值
         * 因为 每类任务之间必须要有n个单位时间的冷冻期，所以前面 max-1 轮，耗时 (max-1)*(n-1),加上最后剩下的任务执行时间
         * 那如果 total 大于上面这个值，则说明执行任务是不会有空余的冷冻时间，耗时就是total
         **/
        int[] queue = new int[26];
        int max = 0;
        int total = 0;
        int count = 0;
        for (char t : tasks) {
            queue[t - 'A']++;
        }
        for (int i : queue) {
            total += i;
            max = Math.max(max, i);
        }

        for (int i : queue) {
            if (i == max) count++;
        }

        int cal = (max - 1) * (n + 1) + count;

        return cal > total ? cal : total;

    }

    public int leastInterval1(char[] tasks, int n) {
        /**
         * @Author slwhy
         * @Date 2020/5/14
         * @Param [tasks, n]
         * @return int
         * @Description leetcode上的方法，基于排序，优先执行量大的任务；以n+1个单位时间为窗口
         * 每个窗口内，同类型的任务只能执行一次，每执行完一轮的时候，要对任务队列按任务量重新进行排序
         * 这里有一个容易混淆的点，queue[0]并不一定是代表‘A’类任务的量，因为会对任务队列进行排序，
         * 但只要保证每个类型的任务量没有问题，且每个任务执行之间会有符合要求的冷冻时间即可
         **/
        int time = 0;
        int[] queue = new int[26];
        for (char t : tasks) {
            queue[t - 'A']++;
        }
        Arrays.sort(queue);
        while (queue[25] > 0) {
            for (int i = 0; i <= n; i++) {
                if (queue[25] <= 0) break;
                if (i < 26 && queue[25 - i] > 0) queue[25 - i]--;
                time++;
            }
            Arrays.sort(queue);
        }
        return time;
    }
}