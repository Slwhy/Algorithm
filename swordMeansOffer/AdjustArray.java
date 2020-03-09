package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 调整数组，
 * 使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * @date: 2019/5/2
 */
public class AdjustArray {
    public static void reOrderArray(int [] array) {
        /**
         * @description 暴力解法,未能证明为何双重循环一定能满足
         * @author slwhy
         * @date 2019/5/2
         * @param array
         * @return void
         */

        int tab = 0;
        for (int i=0;i<array.length-1;i++){
            for (int j= 0;j<array.length-1;j++){
                if (array[j]%2==0&&array[j+1]%2==1){
                    tab = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tab;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,8,3,4,9,6,5,10,12};
        reOrderArray(array);
    }
}
