package leetcode.primary;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/3/18
 * @description: 102. 二叉树的层次遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        int count = 0;
        TreeNode node;
        queue1.add(root);
        while (!queue1.isEmpty()) {
            count = queue1.size();
            List<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                node = queue1.poll();
                tmp.add(node.val);
                if (node.left != null) queue1.add(node.left);
                if (node.right != null) queue1.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
