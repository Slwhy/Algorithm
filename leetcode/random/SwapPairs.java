package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/11/6
 * @description: num 24
 */
public class SwapPairs {
    public static ListNode swapPairs3(ListNode head) {
        //递归解法
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs3(next.next);
        next.next = head;
        return next;
    }

    public static ListNode swapPairs2(ListNode head) {
        //对方法1进行代码优化
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode pre = root;
        ListNode frist = pre.next;
        ListNode second = frist.next;
        while (frist != null & second != null) {
            pre.next = second;
            frist.next = second.next;
            second.next = frist;
            if (pre.next.next.next == null || pre.next.next.next.next == null) return root.next;
            pre = pre.next.next;
            frist = pre.next;
            second = frist.next;
        }
        return root.next;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode frist = head;
        ListNode second = frist.next;
        head = second;
        frist.next = second.next;
        second.next = frist;
        if (head.next.next == null || head.next.next.next == null) return head;
        ListNode pre = head.next;
        frist = pre.next;
        second = frist.next;
        while (frist != null && second != null) {
            pre.next = second;
            frist.next = second.next;
            second.next = frist;
            if (pre.next.next.next == null || pre.next.next.next.next == null) break;
            pre = pre.next.next;
            frist = pre.next;
            second = frist.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        swapPairs3(head);
    }
}
