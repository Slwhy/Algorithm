//
// Created by slwhy on 2022/3/15.
//
#include "vector"

using namespace std;

vector<vector<int>> matrixReshape(vector<vector<int>> &mat, int r, int c) {
    int m = mat.size(), n = mat[0].size();
    if (m * n != r * c) return mat;
    int count = 0;
    vector<vector<int>> res = vector<vector<int>>(r, vector<int>(c, 0));
    vector<int> line;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            res[count / c][count % c] = mat[i][j];
            count++;
        }
    }
    return res;
}