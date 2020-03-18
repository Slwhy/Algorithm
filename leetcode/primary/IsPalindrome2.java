package leetcode.primary;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 回文链表
 */
public class IsPalindrome2 {

    public boolean isPalindrome(ListNode head) {
        /**
         * @Author slwhy
         * @Date 2020/3/17
         * @Param [head]
         * @return boolean
         * @Description 数学方法, 这个leetcode过不了, 该方法需要每个节点的值均为个位数,
         * 其实就是一遍头插法,一遍尾插法,而后对比这两者的结果
         **/
        int num1 = 0, num2 = 0;
        int t = 1;
        while (head != null) {
            num1 = num1 * 10 + head.val;
            num2 = num2 + head.val * t;
            head = head.next;
            t = t * 10;
        }
        return num1 == num2;
    }

    public boolean isPalindrome2(ListNode head) {
        /**
         * @Author slwhy
         * @Date 2020/3/17
         * @Param [head]
         * @return boolean
         * @Description 先把链表转换成数组, 而后利用判断回文数组的方法
         **/
        ArrayList tmp = new ArrayList();
        ListNode p = head;
        while (p != null) {
            tmp.add(p.val);
            p = p.next;
        }
        int left = 0, right = tmp.size() - 1;
        while (left < right) {
            if (!tmp.get(left++).equals(tmp.get(right--))) return false;
        }
        return true;
    }
}
