package swordMeansOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2019/9/30
 * @description: 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstAppearingOnce {

    public Queue<String> queue = new LinkedList<String>();
    public int[] chars = new int[128];

    public void Insert1(char ch) {
        /**
         * @Author slwhy
         * @Date 2019/9/30
         * @Param [ch]
         * @return void
         * @Description 根据牛客上的思路写出来的
         **/
        if (chars[ch] == 0) {
            queue.add(String.valueOf(ch));
            chars[ch] = 1;
        } else {
            chars[ch]++;
        }

    }

    public char FirstAppearingOnce2() {
        char tmp = '#';
        char res = '#';
        if (!queue.isEmpty()) {
            while (!queue.isEmpty()) {
                tmp = queue.peek().charAt(0);//不能直接将队列里面的元素弹出，只有出现次数超过1次的才能弹出
                //if (chars[tmp] == 1)  这里如果这么写，如果字符流是goog，返回的结果是gggo,正确结果应该是ggg#
                if (chars[tmp] == 1) {
                    res = tmp;
                    break;
                }
                if (chars[tmp] > 1) queue.poll();
            }
        }
        return res;
    }


    int count[] = new int[256];
    //Insert one char from stringstream
    int index = 1;

    public void Insert(char ch) {
        /**
         * @Author slwhy
         * @Date 2019/9/30
         * @Param [ch]
         * @return void
         * @Description 牛客上的方法
         * https://www.nowcoder.com/profile/8069912/codeBookDetail?submissionId=18797974
         **/
        if (count[ch] == 0) {
            count[ch] = index++;
        } else {
            count[ch] = -1;
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int temp = Integer.MAX_VALUE;
        char ch = '#';
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0 && count[i] != -1 && count[i] < temp) {
                temp = count[i];
                ch = (char) i;
            }
        }
        return ch;
    }
}
