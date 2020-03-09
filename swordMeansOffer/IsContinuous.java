package swordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: slwhy
 * @date: 2019/9/30
 * @description: LL今天心情特别好, 因为他去买了一副扑克牌, 发现里面居然有2个大王, 2个小王(一副牌原本是54张 ^ _ ^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,
 * 他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，
 * 否则就输出false。为了方便起见,你可以认为大小王是0
 */
public class IsContinuous {
    public static boolean isContinuous2(int[] numbers) {
        /**
         * @Author slwhy
         * @Date 2019/9/30
         * @Param [numbers]
         * @return boolean
         * @Description
         * 牛客上的方法
         * https://www.nowcoder.com/profile/5462253/codeBookDetail?submissionId=20815475
         **/
        if (numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if (number < 0 || number > 13) return false;
            if (number == 0) continue;
            //用位运算判断数组是否含有重复元素，一个32位的int，如果第几位为1，说明那个数之前出现过，
            // 因为这个1是通过左移n位过去的
            if (((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);
            if (number > max) max = number;
            if (number < min) min = number;
            if (max - min >= 5) return false;
        }
        return true;
    }

    public static boolean isContinuous1(int[] numbers) {
        /**
         * @Author slwhy
         * @Date 2019/9/30
         * @Param [numbers]
         * @return boolean
         * @Description 根据牛客上思路，自己写出来的
         **/
        if (numbers.length != 5) return false;
        ArrayList<Integer> num = new ArrayList<Integer>();
        int num_0 = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                num_0++;
            } else {
                num.add(numbers[i]);
            }
        }
        Collections.sort(num);
        for (int i = 1; i < num.size(); i++) {
            if (num_0 < 0) return false;
            if (num.get(i).equals(num.get(i - 1))) return false;
            if (num.get(i) - num.get(i - 1) > 1) {
                //两个数之间相差多少，就需要多少个0来填充，要注意差减一，因为相差一个不需要填充
                num_0 = num_0 - (num.get(i) - num.get(i - 1) - 1);
            }
        }
        if (num_0 >= 0) return true;
        else return false;
    }


    public static void main(String[] args) {

    }
}
