//
// Created by slwhy on 2022/4/3.
//
#include "vector"

using namespace std;

bool comp435(vector<int> num1, vector<int> num2) {
    return num1[1] <= num2[1];
}

int eraseOverlapIntervals(vector<vector<int>> &intervals) {
    //std::sort(intervals.begin(), intervals.end(), comp);
    // 发现一个神奇的现象，用上面的排序代码会超时，但是换成下面的就不会
    sort(intervals.begin(), intervals.end(), [](const auto &u, const auto &v) {
        return u[1] < v[1];
    });

    int count = 0, end = intervals[0][1];
    for (int i = 1; i < intervals.size(); ++i) {
        if (intervals[i][0] >= end) {
            end = intervals[i][1];
        } else {
            count++;
            end = end > intervals[i][1] ? intervals[i][1] : end;
        }
    }
    return count;
}
