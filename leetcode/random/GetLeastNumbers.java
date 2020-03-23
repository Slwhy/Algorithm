package leetcode.random;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/20
 * @description: 面试题40. 最小的k个数
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        int min;
        int index;
        for (int i = 0; i < k; i++) {
            min = arr[i];
            index =i;
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
        return Arrays.copyOf(arr, k);
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1};
        GetLeastNumbers get = new GetLeastNumbers();
        get.getLeastNumbers(arr, 2);
    }
}
