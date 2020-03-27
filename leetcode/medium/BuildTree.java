package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/3/27
 * @description: 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeCore(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTreeCore(int[] preorder, int[] inorder, int index, int left, int right) {
        if (left == right) {
            TreeNode node = new TreeNode(inorder[left]);
            return node;
        } else if (left < right) {
            for (int i = index; i < preorder.length; i++) {
                for (int j = left; j <= right; j++) {
                    if (preorder[i] == inorder[j]) {
                        TreeNode node = new TreeNode(inorder[j]);
                        node.left = buildTreeCore(preorder, inorder, i + 1, left, j - 1);
                        node.right = buildTreeCore(preorder, inorder, i + 1, j + 1, right);
                        return node;
                    }
                }
            }
            return null;
        } else return null;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(new int[]{1, 2}, new int[]{2, 1});
    }
}
