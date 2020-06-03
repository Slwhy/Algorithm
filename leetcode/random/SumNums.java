package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/6/2
 * @description: 面试题64. 求1+2+…+n
 */
public class SumNums {
    public int sumNums(int n) {
        /**
         * @Author slwhy
         * @Date 2020/6/2
         * @Param [n]
         * @return int
         * @Description leetcode 上的思路,利用逻辑运算短路,避免了if的使用
         **/
        int sum = n;
        boolean flag = n > 1 && (sum += sumNums(n - 1)) > 0;
        return sum;
    }
}
