package sort;

/**
 * @author: slwhy
 * @description: 归并排序
 * @date: 2019/5/14
 */
public class Merge {
    public static void merge(int[] array) {
        if (array.length < 1) {
            return;
        }
        int[] copy = new int[array.length];
        mergeCore(array, copy, 0, array.length - 1);

    }

    public static void mergeCore(int[] array, int[] copy, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeCore(array, copy, left, mid);
        mergeCore(array, copy, mid + 1, right);
        int i = mid;
        int j = right;
        int copyLoop = right;
        while (i >= left && j > mid) {
            if (array[i] > array[j]) {
                copy[copyLoop--] = array[i--];
            } else {
                copy[copyLoop--] = array[j--];
            }
        }
        while (i >= left) {
            copy[copyLoop--] = array[i--];
        }
        while (j > mid) {
            copy[copyLoop--] = array[j--];
        }
        for (int n = left; n <= right; n++) {
            array[n] = copy[n];
        }

    }


    public static void main(String[] args) {
        int[] array = new int[]{8, 2, 5, 3, 9, 6, 7, 1};
        merge(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
