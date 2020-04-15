package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/14
 * @description: 240. 搜索二维矩阵 II
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        for (int i = 0; i < matrix.length && matrix[i].length > 0 && !res && matrix[i][0] <= target; i++) {
            if (matrix[i][matrix[i].length - 1] == target) return true;
            if (matrix[i][matrix[i].length - 1] > target)
                res = binary(matrix[i], 0, matrix[i].length - 2, target);
        }
        return res;
    }

    public boolean binary(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return true;
            if (arr[mid] > target) return binary(arr, left, mid - 1, target);
            else return binary(arr, mid + 1, right, target);
        } else return false;
    }
}
