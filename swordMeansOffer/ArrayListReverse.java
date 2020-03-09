package swordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 问题：对链表进行反转，结果返回一个ArrayList
 *
 * 思路：常规对于链表的反转，常规思路利用递归，但这个需要返回一个ArrayList，
 * 所以我的思路是，先利用一个ArrayList 将链表的数值正向记录下来，而后将该ArrayList反转
 * */

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ArrayListReverse {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (listNode!=null){
            res.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayListReverse a = new ArrayListReverse();
        res = a.printListFromTailToHead(null);
        System.out.println(res);

    }
}
