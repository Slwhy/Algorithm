//
// Created by slwhy on 2022/2/20.
//
#include "vector"

using namespace std;

int minimumTotal2(vector<vector<int>> &triangle) {
    vector<vector<int>> dp;
    int res = 10001;
    for (int i = 0; i < triangle.size(); ++i) {
        dp.emplace_back(triangle[i]);
        for (int j = 0; j < triangle[i].size() && i > 0; ++j) {
            int left = 10001,right = 10001;
            if (j-1>=0) left = dp[i-1][j-1];
            if (j<dp[i-1].size()) right = dp[i-1][j];
            dp[i][j] = min(left,right)+triangle[i][j];
        }
    }
    for (int i = 0; i < dp[dp.size() - 1].size(); ++i) {
        res = min(dp[dp.size() - 1][i], res);
    }
    return res;
}

int minimumTotal(vector<vector<int>>& triangle) {
    // 内存优化，原地修改，不用dp数组
    int res = 10001;
    for (int i = 0; i < triangle.size(); ++i) {
        //triangle[i] = triangle[i];
        for (int j = 0; j < triangle[i].size() && i > 0; ++j) {
            int left = 10001, right = 10001;
            if (j - 1 >= 0) left = triangle[i - 1][j - 1];
            if (j < triangle[i - 1].size()) right = triangle[i - 1][j];
            triangle[i][j] = min(left, right) + triangle[i][j];
        }
    }
    for (int i = 0; i < triangle[triangle.size() - 1].size(); ++i) {
        res = min(triangle[triangle.size() - 1][i], res);
    }
    return res;
}

