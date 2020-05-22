package leetcode.medium;

import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/3/27
 * @description: 105. 从前序与中序遍历序列构造二叉树
 */
public class BuildTree {

    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        /**
         * @Author slwhy
         * @Date 2020/5/22
         * @Param [preorder, inorder, preLeft, preRight, inLeft, inRight]
         * @return leetcode.medium.TreeNode
         * @Description leetcode 上的思路,利用hashmap和前序遍历的时候左子树一定在右子树的前面，
         * 在寻找根节点的时候，避免了循环查找
         **/
        if (inLeft > inRight) {
            return null;
        }
        int inRoot = indexMap.get(preorder[preLeft]);
        TreeNode node = new TreeNode(preorder[preLeft]);
        int leftSizt = inRoot - inLeft;
        node.left = helper(preorder, inorder, preLeft + 1, preLeft + leftSizt, inLeft, inRoot - 1);
        node.right = helper(preorder, inorder, preLeft + leftSizt + 1, preRight, inRoot + 1, inRight);
        return node;

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
