package sort;

/**
 * @author: slwhy
 * @description: 冒泡排序
 * @date: 2019/5/14
 */
public class Bubble {
    public static void sort(int[] source) {
        int lent = source.length;
        int tab;
        for (int i = 0; i < lent; i++) {
            for (int j = 0;j<lent-i-1;j++){
                if (source[j]>source[j+1]){
                   tab = source[j];
                   source[j] = source[j+1];
                   source[j+1] = tab;
                }
            }
        }

    }

    public static void main(String[] args) {
        int [] nums = {1,5,2,8,3,6,4,7};
        sort(nums);
        for (int i=0;i<nums.length;i++){
            System.out.print(nums[i]);
        }

    }
}
