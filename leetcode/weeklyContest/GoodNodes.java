package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/5/16
 * @description: //todo
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class GoodNodes {
    public int count = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode node, int max) {
        if (node != null) {
            if (node.val >= max) {
                count++;
                dfs(node.left, node.val);
                dfs(node.right, node.val);
            } else {
                dfs(node.left, max);
                dfs(node.right, max);
            }
        }
    }
}
