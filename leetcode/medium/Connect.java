package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/3/27
 * @description: 116. 填充每个节点的下一个右侧节点指针
 */

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Connect {

    public Node connect(Node root) {
        /**
         * @Author slwhy
         * @Date 2020/3/27
         * @Param [root]
         * @return leetcode.medium.Node
         * @Description leetcode 上的拉链法
         **/
        if (root == null) return root;
        Node left = root.left;
        Node right = root.right;
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        connect(root.left);
        connect(root.right);
        // root.next = null;
        return root;
    }

    public Node connect1(Node root) {
        /**
         * @Author slwhy
         * @Date 2020/3/27
         * @Param [root]
         * @return leetcode.medium.Node
         * @Description 层次遍历
         **/
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<Node>();
        Node pre = root;
        Node curr = root;
        int size;
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                // if (curr==null) continue;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                if (i == 0) {
                    pre = curr;
                    continue;
                }
                pre.next = curr;
                pre = curr;
            }
            curr.next = null;
        }
        return root;
    }
}
