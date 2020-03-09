package swordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: slwhy
 * @date: 2019/9/30
 * @description: 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数
 */
public class GetMedian {
    public ArrayList<Integer> number = new ArrayList<>();

    public void Insert(Integer num) {
        number.add(num);
    }

    public Double GetMedian() {
        /**
         * @Author slwhy
         * @Date 2019/9/30
         * @Param []
         * @return java.lang.Double
         * @Description 自己想出来的暴力解法，每次对数据进行一次排序
         * 牛客：https://www.nowcoder.com/profile/3904759/codeBookDetail?submissionId=22498336
         * 两种思路很具有参考价值
         * 1，构建一颗平衡二叉搜索树
         * 2，构建一个大根堆和一个小根堆
         **/
        int lent = number.size();
        Collections.sort(number);
        if (lent % 2 != 0) {
            return number.get(lent / 2) * 1.0;
        } else {
            return (number.get(lent / 2 - 1) + number.get(lent / 2)) / 2.0;
        }
    }
}
