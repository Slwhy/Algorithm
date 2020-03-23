package leetcode.random;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/6
 * @description: 面试题57 - II. 和为s的连续正数序列
 */
public class FindContinuousSequence {

    public static int[][] findContinuousSequence(int target) {
        /**
         * @Author slwhy
         * @Date 2020/3/6
         * @Param [target]
         * @return int[][]
         * @Description 滑动窗口解法，这一类问题的通用解法，没想到
         **/
        ArrayList<int[]> resList = new ArrayList<>();
        int[] array = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            array[i] = i;
        }
        int left = 1, right = 2;
        while (left <= target / 2 && left < right && right <= target) {
            if ((left + right) * (right - left + 1) / 2 == target) {
                int[] tmp = new int[right - left + 1];
                int curr = 0;
                for (int i = left; i <= right; i++) {
                    tmp[curr++] = i;
                }
                right++;
                resList.add(tmp);
            }
            if ((left + right) * (right - left + 1) / 2 > target) {
                left++;
            }
            if ((left + right) * (right - left + 1) / 2 < target) {
                right++;
            }
        }
        return resList.toArray(new int[resList.size()][]);
    }

    public static int[][] findContinuousSequence2(int target) {
        /**
         * @Author slwhy
         * @Date 2020/3/6
         * @Param [target]
         * @return int[][]
         * @Description 如果连续n个数之和为target，那这那个数必定是从 target/n 向两边扩展，
         * 根据(target/2)>(n/2),可得n的取值范围，因为不知道具体有多少组数据符合条件，利用一个arrayLIst暂存
         **/
        ArrayList<int[]> res = new ArrayList<>();
        int curr = 0;
        for (int i = (int) Math.sqrt(2 * target); i > 1; i--) {
            if (i % 2 == 0) {
                if (target % (i / 2) == 0 && target / (i / 2) == 2 * (target / i) + 1) {
                    int[] tmp = new int[i];
                    for (int j = 0; j < i; j++) {
                        tmp[j] = (target / i) - i / 2 + 1 + j;
                    }
                    res.add(tmp);
                }
            } else {
                if (target % i == 0) {
                    int[] tmp = new int[i];
                    for (int j = 0; j < i; j++) {
                        tmp[j] = target / i - (i - 1) / 2 + j;
                    }
                    res.add(tmp);
                }
            }
        }
        int[][] array = new int[res.size()][];
        for (int[] item : res) {
            array[curr++] = item;
        }
        return array;
    }

    public static void main(String[] args) {
        findContinuousSequence(9);
    }

}
