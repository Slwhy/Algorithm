//
// Created by slwhy on 2022/2/28.
//
#include "vector"
#include "iostream"

using namespace std;

vector<int> getRow(int rowIndex) {
    if (rowIndex < 1) return {1};
    vector<vector<int>> result;
    vector<int> layer0 = {1};
    vector<int> layer1 = {1, 1};
    result.emplace_back(layer0);
    result.emplace_back(layer1);
    for (int i = 2; i <= rowIndex; ++i) {
        vector<int> curr;
        curr.emplace_back(1);
        for (int j = 1; j < i; ++j) {
            curr.emplace_back(result[i - 1][j - 1] + result[i - 1][j]);
        }
        curr.emplace_back(1);
        result.emplace_back(curr);
    }
    return result[rowIndex];
}

