package swordMeansOffer;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @description: 求1到n的所有整数中，1出现的个数
 * @date: 2019/5/28
 */
public class NumberOf1Between1AndN {

    public static int NumberOf1Between1AndN_Solution(int n) {
        /**
         * @description 参考牛客代码
         * https://www.nowcoder.com/profile/777651/codeBookDetail?submissionId=1503231
         * 思路，对当前位置的值分三种情况考虑，
         * 当current=0时，当前位置为1的个数为，高位*10的n次方，n为第几位
         * 当current=1时，当前位置为1的个数为，高位*10的n次方+当前位后面的数+1
         * 当current>1时，当前位置为1的个数为，（高位+1）*10的n次方
         * @author slwhy
         * @date 2019/5/28
         * @param n
         * @return int
         */

        int count = 0;
        int current = 0;
        int before = 0;
        int after = 0;
        int i = 1;
        while (n/i>0){
            current = (n/i)%10;
            before = n/(i*10);
            after = n - (n/i)*i;
            if (current==0){
                count = count + before*i;
            }else if (current==1){
                count = count + before*i+after+1;
            }else {
                count = count + (before+1)*i;
            }

            i = i*10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 55;
        System.out.println(NumberOf1Between1AndN_Solution(n));
    }
}
