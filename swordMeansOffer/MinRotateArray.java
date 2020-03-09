package swordMeansOffer;

/**问题：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 *
 * */

public class MinRotateArray {
    public static int minNumberInRotateArrayViolence(int [] array) {
        /**暴力遍历整个数组，求出其中的最小值
         * */
        if (array.length==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<array.length;i++){
            if (array[i]<min){
                min = array[i];
            }
        }
        return min;
    }

    public static int minNumberInRotateArray1(int [] array) {
        /**利用了非减数组的特性，但时空复杂度还不够优秀
         * */
        int lent = array.length;
        if (lent==0){
            return 0;
        }
        for (int i = 0;i<lent-1;i++){
            if (array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[lent-1];
    }

    public static int minNumberInRotateArray(int [] array) {
        /**考虑二分法，通过中间指针判断处于原序列部分，还是经过旋转的部分，以此来减少遍历的次数
         * 不过这种方法面临数组有重复元素出现时会比较麻烦
         * 例如，{1，0，1，1，1｝ 和 ｛1，1， 1，0，1｝ 都可以看成是递增排序数组｛0，1，1，1，1｝的旋转，
         * 这样的序列，就无法通过中间指针进行判断
         * */
        int lent = array.length;
        int mid = lent/2;
        if (lent==0){
            return 0;
        }
        if (lent==1){
            return array[0];
        }
        if (array[mid]>array[0] | array[mid]>array[lent-1]){
            for (int i = mid;i<lent-1;i++){
                if (array[i]>array[i+1]){
                    return array[i+1];
                }
            }
            return array[lent-1];
        }
        if (array[mid]<array[0] | array[mid]<array[lent-1]){
            for (int i = mid;i>0;i--){
                if (array[i-1]>array[i]){
                    return array[i];
                }
            }
            return array[0];
        }
        else {
            for (int i = 0;i<lent-1;i++){
                if (array[i]>array[i+1]){
                    return array[i+1];
                }
            }
            return array[lent-1];
        }

    }


    public static void main(String[] args) {
        int [] a = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        int n = minNumberInRotateArray(a);
        System.out.println(n);
    }
}
