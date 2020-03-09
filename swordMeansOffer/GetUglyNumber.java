package swordMeansOffer;

import java.util.ArrayList;

import static java.lang.Math.min;

/**
 * @author: slwhy
 * @date: 2019/9/27
 * @description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 */
public class GetUglyNumber {

    public static int getUglyNumber(int index) {
        /**
         * @Author slwhy
         * @Date 2019/9/28
         * @Param [index]
         * @return int
         * @Description 看了牛客牛客的方法，自己复现的
         **/
        if (index < 1) {
            return 0;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        int subs2 = 0;
        int subs3 = 0;
        int subs5 = 0;
        res.add(1);
        int tmp;
        while (res.size() <= index) {
            tmp = min(min(res.get(subs2) * 2, res.get(subs3) * 3), res.get(subs5) * 5);
            if (tmp == res.get(subs2) * 2) subs2++;
            if (tmp == res.get(subs3) * 3) subs3++;
            if (tmp == res.get(subs5) * 5) subs5++;
            if (res.get(res.size() - 1) < tmp) res.add(tmp);
        }
        return res.get(index - 1);
    }


    public static int getUglyNumber_Solution(int index) {
        /**
         * @Author slwhy
         * @Date 2019/9/27
         * @Param [index]
         * @return int
         * @Description 牛客上的方法
         * https://www.nowcoder.com/profile/6495135/codeBookDetail?submissionId=20172459
         **/
        if (index <= 0) return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index)//循环的条件
        {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = min(m2, min(m3, m5));
            list.add(min);
            if (min == m2) i2++;
            if (min == m3) i3++;
            if (min == m5) i5++;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(getUglyNumber(25));
        System.out.println(getUglyNumber_Solution(25));
    }
}
