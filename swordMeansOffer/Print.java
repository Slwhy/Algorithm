package swordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2019/9/16
 * @description: 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推
 */
public class Print {
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [pRoot]
         * @return java.util.ArrayList<java.util.ArrayList < java.lang.Integer>>
         * @Description 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行（这是另一道题）
         **/
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        res.get(0).add(pRoot.val);
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        TreeNode node;
        queue1.offer(pRoot);
        int cout;
        int num;
        while (!queue1.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            num = 0;
            cout = queue1.size();
            while (num < cout) {
                node = queue1.poll();
                num++;
                if (node.left != null) {
                    queue1.offer(node.left);
                    row.add(node.left.val);
                }
                if (node.right != null) {
                    queue1.offer(node.right);
                    row.add(node.right.val);
                }
            }
            if (row.size() > 0) {
                res.add(row);
            }
        }
        return res;

    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [pRoot]
         * @return java.util.ArrayList<java.util.ArrayList < java.lang.Integer>>
         * @Description
         * 贼麻烦的方法，还借鉴了一下网络
         **/
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return res;
        }
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(pRoot.val);
        res.add(row1);
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        TreeNode node;
        queue1.offer(pRoot);
        int count = 1;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            count++;
            ArrayList<Integer> row = new ArrayList<Integer>();
            while (!queue1.isEmpty()) {
                node = queue1.poll();
                if (node.left != null) {
                    queue2.offer(node.left);
                    row.add(node.left.val);
                }
                if (node.right != null) {
                    queue2.offer(node.right);
                    row.add(node.right.val);
                }
            }
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            if (count % 2 == 0) {
                Collections.reverse(row);
            }
            if (row.size() > 0) {
                res.add(row);
            }
        }
        return res;
    }
}
