package leetcode;

/**
 * @author: slwhy
 * @date: 2019/10/7
 * @description: num 2
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
        ListNode res = new ListNode(0);
        ListNode p = res;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        int tmp;
        while (p1 != null && p2 != null) {
            tmp = p1.val + p2.val + carry;
            if (tmp > 9) {
                carry = 1;
                tmp = tmp % 10;
            } else carry = 0;
            ListNode node = new ListNode(tmp);
            p.next = node;
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            tmp = p1.val + carry;
            if (tmp > 9) {
                carry = 1;
                tmp = tmp % 10;
            } else carry = 0;
            ListNode node = new ListNode(tmp);
            p.next = node;
            p = p.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            tmp = p2.val + carry;
            if (tmp > 9) {
                carry = 1;
                tmp = tmp % 10;
            } else carry = 0;
            ListNode node = new ListNode(tmp);
            p.next = node;
            p = p.next;
            p2 = p2.next;
        }
        if (carry != 0) { //不要忘记最后的进位，如果有进位，需要new 一个 Node
            ListNode node = new ListNode(carry);
            p.next = node;
            p = p.next;
        }
        return res.next;
    }
}
