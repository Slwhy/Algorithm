package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/4
 * @description:
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
public class Sum {
    public static int Sum_Solution(int n) {
        /**
        * @Author slwhy
        * @Date 2019/9/4
        * @Param [n]
        * @return int
        * @Description //用递归实现
        **/
        if (n <= 1) {
            return n;
        }
        return n + Sum_Solution(n - 1);
    }

}
