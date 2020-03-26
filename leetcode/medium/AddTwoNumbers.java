package leetcode.medium;


/**
 * @author: slwhy
 * @date: 2020/3/26
 * @description: 2. 两数相加
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * @Author slwhy
         * @Date 2020/3/26
         * @Param [l1, l2]
         * @return leetcode.medium.ListNode
         * @Description 相比于第一次的判断l1, l2是否为空, 这次简化了代码
         **/
        int carry = 0;
        ListNode res = new ListNode(0);
        ListNode p = res;
        int tmp;
        int num1;
        int num2;
        while (l1 != null || l2 != null || carry != 0) {
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            tmp = num1 + num2 + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            ListNode node = new ListNode(tmp);
            p.next = node;
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return res.next;
    }
}
