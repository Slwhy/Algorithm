package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/3/26
 * @description: 94. 二叉树的中序遍历
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InorderTraversal {
    public List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/3/26
         * @Param [root]
         * @return java.util.List<java.lang.Integer>
         * @Description 栈实现中序遍历
         **/
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;

        }
        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/3/26
         * @Param [root]
         * @return java.util.List<java.lang.Integer>
         * @Description 递归解法
         **/
        inorderTraversalCore(root);
        return res;
    }

    public void inorderTraversalCore(TreeNode root) {
        if (root != null) {
            inorderTraversalCore(root.left);
            res.add(root.val);
            inorderTraversalCore(root.right);
        }
    }
}
