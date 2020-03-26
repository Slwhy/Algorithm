package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/3/26
 * @description: 160. 相交链表
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         * @Author slwhy
         * @Date 2020/3/26
         * @Param [headA, headB]
         * @return leetcode.medium.ListNode
         * @Description 尾部对齐策略
         **/
        int lent1 = 0;
        int lent2 = 0;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            lent1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            lent2++;
            p2 = p2.next;
        }
        p1 = headA;
        p2 = headB;
        while (lent1 > lent2) {
            p1 = p1.next;
            lent1--;
        }
        while (lent2 > lent1) {
            p2 = p2.next;
            lent2--;
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) return p1;
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
    }
}
