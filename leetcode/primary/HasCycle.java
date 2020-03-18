package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 环形链表
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        /**
         * @Author slwhy
         * @Date 2020/3/17
         * @Param [head]
         * @return boolean
         * @Description 快慢指针
         **/
        ListNode quick = head;
        ListNode small = head;
        while (quick != null && small != null) {
            if (quick.next != null) {
                small = small.next;
                quick = quick.next.next;
                if (quick == small) return true;
            } else return false;
        }
        return false;
    }
}
