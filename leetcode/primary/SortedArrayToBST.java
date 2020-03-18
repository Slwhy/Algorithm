package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/18
 * @description: 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/18
         * @Param [nums]
         * @return leetcode.primary.TreeNode
         * @Description 递归, 根据二叉搜索树的性质, 每次把数组分成三部分
         * 1.当前节点的值
         * 2.左子树的值
         * 3.右子树的值
         **/
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTCore(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        } else if (left < right) {
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = sortedArrayToBSTCore(nums, left, mid - 1);
            node.right = sortedArrayToBSTCore(nums, mid + 1, right);
            return node;
        } else return null;
    }
}
