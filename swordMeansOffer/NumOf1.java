package swordMeansOffer;

/**
 * 问题：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */

public class NumOf1 {
    public static int NumberOfone(int n) {
        /**
         * @description n-1和n相与，可以将n的二进制的最右边一个1转为0，能够进行多少次就说明有多少个1
         * @author 牛客上的
         * @date 2019/5/2
         * @param n
         * @return int
         */
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    public static int NumberOf1(int n) {
        /**
         * @description 自己的解法，正数通过除二取余计算，负数将其转化为补数计算
         * @author slwhy
         * @date 2019/5/2
         * @param n
         * @return int
         */
        int count = 0;
        if (n==0){
            return 0;
        }
        if (n<0){
            n = Integer.MAX_VALUE+n+1;
            if(n==0){
            // -2147483648只有首位为1
                count = 0;
            }else {
                count = 1;
            }
        }
        while (n>=2){
            if (n%2==1){
                count++;
            }
            n = n /2;
        }
        count++;
        return count;
    }


    public static String tenToTwo(int num) {
        /**
         * @description 将十进制转换为二进制
         * @author slwhy
         * @date 2019/5/2
         * @param num
         * @return java.lang.String
         */
        String res = "";
        while (num >= 2) {
            res = num % 2 + res;
            num = num / 2;
        }
        res = num + res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(tenToTwo(30));
        System.out.println(NumberOfone(-2147483648));
        System.out.println(-2147483648-1);
        System.out.println(Integer.MAX_VALUE+(-2147483648));
    }
}
