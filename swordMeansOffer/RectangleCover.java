package swordMeansOffer;

/**
 * 问题：矩形覆盖,我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 */

public class RectangleCover {
    public static int RectCover(int target) {
        /**参考斐波拉契的思想，f(n)=f(n-1)+f(n-2),f(1)=1,f(2)=2
         * */
        int a = 1, b = 2, c = target;
        while (target > 2) {
            c = a + b;
            a = b;
            b = c;
            target -- ;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
