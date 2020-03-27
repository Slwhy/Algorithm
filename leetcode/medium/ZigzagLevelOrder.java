package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/3/27
 * @description: 103. 二叉树的锯齿形层次遍历
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode curr;
        int size;
        boolean isodd = true;
        while (!queue.isEmpty()) {
            size = queue.size();
            LinkedList tmp = new LinkedList();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (curr == null) continue;
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                if (isodd) tmp.addLast(curr.val);
                else tmp.addFirst(curr.val);
            }
            res.add(tmp);
            isodd = !isodd;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList tmp = new ArrayList();

    }
}
