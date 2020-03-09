package swordMeansOffer;

import static java.lang.Math.pow;

/**
 * @author: slwhy
 * @date: 2019/9/20
 * @description: 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRope {
    public static int cutRope(int target) {
        /**
         * @Author slwhy
         * @Date 2019/9/20
         * @Param [target]
         * @return int
         * @Description 贪心证明
         * https://blog.csdn.net/Xqing_2016/article/details/87901262
         * 注解:a(n-a)>n 满足这个条件的不一定是最优解，但是这样切一定比那些不满足条件的切法更优，而且当n>=5，a>=1时 a的整数解只有2，3，所以每次切2，或者3，一定会比切其他长度更优
         * 至于，为什么每次切3，而不是切2，则是比较2(n-2)和3(n-3)的大小问题了，很明显，在n>5的时候,切3比切2更优
         *
         **/
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;

        int timesOf3 = target / 3;

        /*  当最后绳子长度为 4 时，这时候分割成 2，2 而不是 3，1 因为2*2=4 > 3=3*1  */
        if (target - timesOf3 * 3 == 1)
            timesOf3--;

        int timesOf2 = (target - timesOf3 * 3) / 2;

        return (int) (pow(3, timesOf3)) * (int) (pow(2, timesOf2));
    }

    public static int cutRope1(int target) {
        /**
         * @Author slwhy
         * @Date 2019/9/20
         * @Param [target]
         * @return int
         * @Description
         * 动态规划，还需要多多理解（可以整理一下动态规划的题目）
         * https://blog.csdn.net/qq_25827845/article/details/73351134
         **/
        if (target < 2)
            return 0;
        if (target == 2)
            return 1;
        if (target == 3)
            return 2;
        // 子问题的最优解存储在f数组中，数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int[] f = new int[target + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for (int i = 4; i <= target; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int num = f[j] * f[i - j];
                if (max < num)
                    max = num;
                f[i] = max;
            }
        }
        result = f[target];
        return result;
    }
}
