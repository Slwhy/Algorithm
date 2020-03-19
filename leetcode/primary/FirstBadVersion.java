package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/19
 * @description: 278. 第一个错误的版本
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [n]
         * @return int
         * @Description 二分的思路不难, 不过有一个坑, left+right 可能会溢出
         **/
        return firstBadVersionCore(1, n);
    }

    public int firstBadVersionCore(int left, int right) {
        if (right == left) return left;
        int n = left / 2 + right / 2;
//        boolean mid = isBadVersion(n);
        boolean mid = false;//因为isBadVersion 是题目定义的函数这里没有,避免编译器飘红,给注释了
        if (!mid) return firstBadVersionCore(n + 1, right);
            //该版本正常,最早出错的一定就是后面的了
        else return firstBadVersionCore(left, n);
        //这里有一个细节,如果该版本有错,最早出错的版本不一定是前面的,有可能就是当前版本
    }
}
