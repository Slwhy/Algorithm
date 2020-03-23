package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/11/11
 * @description: num 23
 */
public class MergeKLists {

    public ListNode mergeKLists3(ListNode[] lists) {
        // 对方法2进行优化,利用了merge的思想，减少两个链表merge的次数
        //为什么二分法比逐一merge快很多，两个链表两两merge的次数并没有减少啊
        ListNode res = mergeKLists3Core(lists, 0, lists.length - 1);
        return res;
    }

    public ListNode mergeKLists3Core(ListNode[] lists, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode left = mergeKLists3Core(lists, start, mid);
            ListNode right = mergeKLists3Core(lists, mid + 1, end);
            return mergeKListsCore2(left, right);
        } else if (start == end) return lists[start];
        else return null;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        //两两合并，在别人提示下
        if (lists.length < 1) return null;
        ListNode res = lists[0];
        for (int i = 1; i < lists.length; i++) {
            res = mergeKListsCore2(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeKListsCore2(ListNode node1, ListNode node2) {
        //将链表两两merge
        ListNode node = new ListNode(0);
        ListNode p = node;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
                p = p.next;
            } else {
                p.next = node2;
                node2 = node2.next;
                p = p.next;
            }
        }
        if (node1 == null) p.next = node2;
        else p.next = node1;
        return node.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //num 23
        //一次完成合并
        ListNode res = new ListNode(1);
        mergeKListsCore(lists, res);

        return res.next;
    }

    public void mergeKListsCore(ListNode[] lists, ListNode node) {
        ListNode tmp = new ListNode(Integer.MAX_VALUE);
        boolean isNull = true;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < tmp.val) tmp = lists[i];
                isNull = false;
            }
        }
        if (!isNull) {
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == tmp) lists[i] = lists[i].next;
            }
            node.next = tmp;
            node = node.next;
            mergeKListsCore(lists, node);
        }
    }
}
