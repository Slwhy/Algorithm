//
// Created by slwhy on 2022/4/3.
//
#include "vector"

using namespace std;

bool searchMatrix2(vector<vector<int>> &matrix, int target) {
    int row = 0, column = matrix[0].size() - 1;
    while (row < matrix.size() && column >= 0) {
        if (matrix[row][column] == target) return true;
        else if (matrix[row][column] > target) column--;
        else row++;
    }
    return false;
}


int binarySearch(vector<int> nums, int target) {
    int left = 0, right = nums.size();
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) right = mid - 1;
        else left = mid + 1;
    }
    return -1;
}

bool searchMatrix(vector<vector<int>> &matrix, int target) {
    for (int i = 0; i < matrix.size(); ++i) {
        if (matrix[i][0] <= target && matrix[i][matrix[0].size() - 1] >= target) {
            if (binarySearch(matrix[i], target) != -1) return true;
        }
    }
    return false;
}