package leetcode.random;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/30
 * @description: 面试题62. 圆圈中最后剩下的数字
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        /**
         * @Author slwhy
         * @Date 2020/3/30
         * @Param [n, m]
         * @return int
         * @Description 约瑟夫环问题求解的数学方法
         * 参考 leetcode https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/
         **/
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }

    public int lastRemaining1(int n, int m) {
        /**
         * @Author slwhy
         * @Date 2020/3/30
         * @Param [n, m]
         * @return int
         * @Description 用数组模拟会超时，数组不方便进行删除操作
         **/
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            tmp.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            tmp.remove(index);
            n--;
        }
        return tmp.get(0);
    }

    public static void main(String[] args) {
        LastRemaining last = new LastRemaining();
        last.lastRemaining(5, 3);
    }
}
