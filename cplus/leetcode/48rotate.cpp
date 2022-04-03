//
// Created by slwhy on 2022/3/29.
//
#include "vector"

using namespace std;

void rotateDfs(vector<vector<int>> &matrix, int left, int right) {
    if (left < right) {
        int tmp;
        int n = matrix.size() - 1;
        for (int i = left; i < right; ++i) {
            tmp = matrix[left][i];
            matrix[left][i] = matrix[n - i][left];
            matrix[n - i][left] = matrix[right][n - i];
            matrix[right][n - i] = matrix[i][right];
            matrix[i][right] = tmp;
        }
        rotateDfs(matrix, left + 1, right - 1);
    }
}


void rotate(vector<vector<int>> &matrix) {
    rotateDfs(matrix, 0, matrix.size() - 1);
}
