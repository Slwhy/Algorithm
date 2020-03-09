package swordMeansOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @description: 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * @date: 2019/5/19
 */
public class PrintTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        /**
         * @description 即二叉树的层次遍历
         * @author slwhy
         * @date 2019/5/19
         * @param root
         * @return java.util.ArrayList<java.lang.Integer>
         */

        ArrayList<Integer> res = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode p;
        queue.offer(root);
        while (!queue.isEmpty()) {
            p = queue.poll();
            if (p == null) {
                break;
            }
            res.add(Integer.valueOf(p.val));
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {


    }
}
