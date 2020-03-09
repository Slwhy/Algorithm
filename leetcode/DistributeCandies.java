package leetcode;


/**
 * @author: slwhy
 * @date: 2020/3/5
 * @description: num 1103
 */
public class DistributeCandies {

    public static int[] distributeCandies(int candies, int num_people) {
        /**
         * @Author slwhy
         * @Date 2020/3/5
         * @Param [candies, num_people]
         * @return int[]
         * @Description 等差数列求和，思路不难想，leetcode上的代码
         **/
        int n = num_people;
        // how many people received complete gifts
        //截至到最后一位无法分到应得的糖果的孩子之前，每次分配的糖果数构成一个等差数列，
        // 通过这个等差数列的限制条件可以求出完整分配糖果的轮数
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for (int i = 0; i < n; ++i) {
            // complete rows
            d[i] = (i + 1) * rows + (int) (rows * (rows - 1) * 0.5) * n;
            // cols in the last row
            if (i < cols) d[i] += i + 1 + rows * n;
        }
        // remaining candies
        d[cols] += remaining;
        return d;
    }

    public static int[] distributeCandies2(int candies, int num_people) {
        /**
         * @Author slwhy
         * @Date 2020/3/5
         * @Param [candies, num_people]
         * @return int[]
         * @Description 暴力解法，用数组模拟分配过程
         **/
        int consume = 0;
        int curr = 0;
        int[] res = new int[num_people];
        int i = 0;
        while (consume < candies) {
            curr++;
            if ((candies - consume) > curr) {
                res[i % num_people] = res[i % num_people] + curr;
                consume += curr;
                i++;
            } else {
                res[i % num_people] = res[i % num_people] + candies - consume;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        distributeCandies2(1000000000, 1000);
        distributeCandies(1000000000, 1000);
    }
}


