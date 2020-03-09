package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同
 * @date: 2019/5/19
 */
public class VerifySquenceOfBST {
    public static boolean verifySquenceOfBST(int[] sequence) {
        /**
         * @description
         * 参考博客：https://www.cnblogs.com/yuanshuang/p/5377581.html
         * 思路：后续遍历末尾为根节点，其中小于根节点的为左子树部分，大于根节点的为右子树部分，
         * 而且左右子树均为连续序列
         * @author slwhy
         * @date 2019/5/22
         * @param sequence
         * @return boolean
         */
        int lent = sequence.length;
        if (lent == 0) {
            return false;
        }
        if (lent == 1 || lent == 2) {
            return true;
        }
        return verify(sequence, 0, lent - 1);

    }

    public static boolean verify(int[] sequence, int head, int tril) {
        if (head >= tril - 1) {
            return true;
        }
        int i = head;
        int root = sequence[tril];
        for (; i < tril; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int tab = i;
        for (; i < tril; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        return verify(sequence, head, tab - 1) && verify(sequence, tab, tril - 1);
    }

    public static void main(String[] args) {
//        int[] arr = {};
//        int[] arr = {1,2,3,4,5};
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        System.out.print(verifySquenceOfBST(arr));

    }
}
