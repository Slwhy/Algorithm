//
// Created by slwhy on 2022/3/15.
//
#include "vector"

using namespace std;

vector<vector<int>> generate(int numRows) {
    vector<vector<int>> res;
    for (int i = 0; i < numRows; ++i) {
        vector<int> line = vector<int>();
        line.emplace_back(1);
        for (int j = 1; j < i; ++j) {
            line.emplace_back(res[i - 1][j - 1] + res[i - 1][j]);
        }
        if (i>0) line.emplace_back(1);
        res.emplace_back(line);
    }
    return res;
}