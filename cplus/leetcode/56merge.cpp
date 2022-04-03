//
// Created by slwhy on 2022/3/28.
//
#include "vector"
#include "iostream"

using namespace std;

bool comp(vector<int> num1, vector<int> num2) {
    return num1[0] < num2[0];
}

vector<vector<int>> merge(vector<vector<int>> &intervals) {
    vector<vector<int>> result;
    std::sort(intervals.begin(), intervals.end(), comp);
    if (intervals.size() < 2) return intervals;
    result.emplace_back(intervals[0]);
    for (int i = 1; i < intervals.size(); ++i) {
        if (intervals[i][0] <= result[result.size() - 1][1] && result[result.size() - 1][1] < intervals[i][1]) {
            result[result.size() - 1][1] = intervals[i][1];
        } else if (intervals[i][0] > result[result.size() - 1][1]) {
            result.emplace_back(intervals[i]);
        }
    }
    return result;
}