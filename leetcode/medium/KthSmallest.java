package leetcode.medium;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/31
 * @description: 230. 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    public ArrayList<Integer> tmp = new ArrayList();

    int n;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        /**
         * @Author slwhy
         * @Date 2020/4/1
         * @Param [root, k]
         * @return int
         * @Description leetcode上的解法，中序遍历+剪枝
         * 进行中序遍历，并统计访问了的节点个数，第k个节点就是结果
         **/
        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        //剪枝
        if (root == null || n > k) return;
        inorder(root.left, k);
        n++;
        if (n == k) res = root.val;
        inorder(root.right, k);
    }

    public int kthSmallest1(TreeNode root, int k) {
        /**
         * @Author slwhy
         * @Date 2020/3/31
         * @Param [root, k]
         * @return int
         * @Description 中序遍历后得到有序数组，返回数组的第k-1个数
         **/
        help(root);
        return tmp.get(k - 1);
    }

    public void help(TreeNode root) {
        if (root != null) {
            help(root.left);
            tmp.add(root.val);
            help(root.right);
        }
    }
}
