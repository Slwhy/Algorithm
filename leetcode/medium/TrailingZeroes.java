package leetcode.medium;


/**
 * @author: slwhy
 * @date: 2020/4/28
 * @description: 172. 阶乘后的零
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/28
         * @Param [n]
         * @return int
         * @Description 统计 n!序列里面 5 的个数，但是具体如何统计没有想到
         **/
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }


    public static void main(String[] args) {

        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes(180854832));
    }
}
