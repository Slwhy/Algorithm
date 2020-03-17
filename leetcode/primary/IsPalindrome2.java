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
         * @Description 先把链表转换成数组,而后利用判断回文数组的方法
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
