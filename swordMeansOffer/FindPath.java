package swordMeansOffer;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @description: 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * @date: 2019/5/22
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        /**
         * @description 没啥思路，参考了牛客上的代码
         * https://www.nowcoder.com/profile/963880/codeBookDetail?submissionId=1512095
         * 要求：路径必须是从根节点到叶子节点的，而且返回结果中路径中的list应该在前面
         * 思路：递归遍历整个二叉树，到叶子节点时判断是否符合路径要求，如果符合加入listAll，
         * 这里新建一个list对象加入listAll中是为了后期对list修改而影响结果（list是成员变量）
         * 利用成员变量保存结果，解决递归返回结果困难问题
         * 每次递归轮结束后要返回上一轮，所以list需要删去末尾元素，为什么target不需要改变，因为其为局部变量
         * @author slwhy
         * @date 2019/5/23
         * @param root
         * @param target
         * @return java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
         */

        if (root != null) {
            list.add(root.val);
            target = target - root.val;
            if (target == 0 && root.right == null && root.left == null) {
                listAll.add(new ArrayList<Integer>(list));
            }
            FindPath(root.left,target);
            FindPath(root.right,target);
            list.remove(list.size()-1);
        }
        return listAll;
    }
}
