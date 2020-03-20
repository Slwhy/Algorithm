package sort;

/**
 * @author: slwhy
 * @date: 2020/3/20
 * @description: 选择排序
 */
public class Select {
    public void selectSort(int[] arr) {
        int min;
        int index;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            arr[index] = arr[i];
            arr[i] = min;
        }
    }

    public static void main(String[] args) {

    }
}
