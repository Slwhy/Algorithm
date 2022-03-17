//
// Created by slwhy on 2022/3/16.
//
#include "vector"

using namespace std;

void setZeroes(vector<vector<int>> &matrix) {
    // 暴力解法，利用 m+n 的位置保存下哪些列和行需要被置 0
    // 常量空间的解法，利用第1行和第1列作为上述的空间保存该行和该列是否需要被置 0，而后增加两个变量保存第1行和第1列是否需要置0
    int m = matrix.size();
    int n = matrix[0].size();
    int *rows = new int[m];
    int *columns = new int[n];
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (matrix[i][j] == 0) {
                rows[i] = 1;
                columns[j] = 1;
            }
        }
    }
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            if (rows[i] == 1 or columns[j] == 1) matrix[i][j] = 0;
        }
    }
}