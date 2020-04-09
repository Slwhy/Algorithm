package sort;

/**
 * @author: slwhy
 * @date: 2020/4/9
 * @description: 基于大根堆的堆排序
 */
public class Heap {
    public void heapSort(int[] array) {
        /**
         * @Author slwhy
         * @Date 2020/4/9
         * @Param [array]
         * @return void
         * @Description 先利用上浮操作进行构建堆,
         * 而后将堆顶和无序部分的最右边元素array[i]交换,因为堆定一直是当前堆中的最大元素,所以 array[i]~array[lent-1]变为有序了
         * 交换堆顶后，进行下沉操作，重新调整为大根堆，(要注意，此时堆的长度缩小了1，因为交换后array[i]已经是有序部分，不是堆部分)
         **/
        for (int i = 1; i < array.length; i++) {
            floating(array, i);
        }
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            sinking(array, i - 1);
        }
    }

    public void floating(int[] array, int index) {
        /**
         * @Author slwhy
         * @Date 2020/4/9
         * @Param [array, index]
         * @return void
         * @Description 进行上浮
         **/
        int father = 0;
        while (father >= 0) {
            father = (index - 1) / 2;
            if (array[father] < array[index]) {
                swap(array, father, index);
                index = father;
            } else father = -1;
        }
    }

    public void sinking(int[] array, int end) {
        /**
         * @Author slwhy
         * @Date 2020/4/9
         * @Param [array, end]
         * @return void
         * @Description 元素下沉
         **/
        int father = 0;
        int child;
        while (father < (end + 1) / 2) {
            if (father * 2 + 2 <= end)
                child = array[father * 2 + 1] > array[father * 2 + 2] ? father * 2 + 1 : father * 2 + 2;
            else child = father * 2 + 1;
            if (array[father] < array[child]) {
                swap(array, father, child);
                father = child;
            } else break;

        }
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 6, 1, 8, 6, 4, 7, 3, 2};
        Heap heap = new Heap();
        heap.heapSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
