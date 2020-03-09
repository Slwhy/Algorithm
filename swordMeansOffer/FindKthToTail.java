package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输出链表中倒数第k个结点
 * @date: 2019/5/2
 */


public class FindKthToTail {
    public ListNode solute(ListNode head, int k) {
        /**
         * @description 需要考虑的异常情况，1，k=0，2，head=null，k的值大于linklist的长度
         * @author slwhy
         * @date 2019/5/2
         * @param head
         * @param k
         * @return ListNode
         */

        ListNode p = head;
        ListNode pre = head;
        int n = 1;
        if (head == null || k == 0) {
            return null;
        }
        while (p.next != null) {
            if (n >= k) {
                pre = pre.next;
            }
            p = p.next;
            n++;
        }
        return n >= k ? pre : null;

    }

    public ListNode solute2(ListNode head, int k) {
        /**
         * @description 6,{1,2,3,4,5}用例无法通过，应该返回null的，却爆了java.lang.NullPointerException错误
         * 这个代码存在问题，有空好好捋捋
         * @author slwhy
         * @date 2019/5/2
         * @param head
         * @param k
         * @return ListNode
         */

        ListNode p = head;
        ListNode pre = head;
        if (head == null || k == 0) {
            return null;
        }
        for (int i = 1; i < k; i++) {
            if (p == null) {
                return null;
            }
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            pre = pre.next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
