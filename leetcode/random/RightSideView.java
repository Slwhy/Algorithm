package leetcode.random;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/4/22
 * @description: 199. 二叉树的右视图
 */
public class RightSideView {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode node, int depth) {
        if (node != null) {
            if (depth == res.size()) {
                res.add(node.val);
            }
            dfs(node.right, depth + 1);
            dfs(node.left, depth + 1);
        }
    }

    public List<Integer> rightSideView1(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/4/22
         * @Param [root]
         * @return java.util.List<java.lang.Integer>
         * @Description 层次遍历解法
         **/
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        int lent;
        TreeNode node;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            lent = queue.size();
            for (int i = 0; i < lent; i++) {
                node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i == lent - 1) res.add(node.val);
            }

        }
        return res;
    }


}
