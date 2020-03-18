package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/18
 * @description: 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeCore(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode buildTreeCore(int[] inorder, int[] postorder, int left, int right, int head) {
        if (left < right && head >= 0) {
            while (head >= 0) {
                for (int i = left; i <= right; i++) {
                    if (inorder[i] == postorder[head]) {
                        TreeNode node = new TreeNode(postorder[head]);
                        node.left = buildTreeCore(inorder, postorder, left, i - 1, head - 1);
                        node.right = buildTreeCore(inorder, postorder, i + 1, right, head - 1);
                        return node;
                    }
                }
                head--;
            }
            return null;
        } else if (left == right) return new TreeNode(inorder[left]);
        else return null;
    }
}
