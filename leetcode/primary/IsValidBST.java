package leetcode.primary;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/18
 * @description: 98. 验证二叉搜索树
 */
public class IsValidBST {

    public ArrayList nums = new ArrayList();

    public boolean isValidBST(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/3/18
         * @Param [root]
         * @return boolean
         * @Description 中序遍历将所有的值全部取出来, 而后判断数组是否有序
         **/
        isValidBSTCore(root);
        for (int i = 0; i < nums.size() - 1; i++) {
            if ((int) nums.get(i) >= (int) nums.get(i + 1)) return false;
        }
        return true;
    }

    public void isValidBSTCore(TreeNode root) {
        if (root != null) {
            isValidBSTCore(root.left);
            nums.add(root.val);
            isValidBSTCore(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
