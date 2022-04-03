//
// Created by slwhy on 2022/3/28.
//
#include "vector"

using namespace std;

void sortColors(vector<int> &nums) {
    vector<int> count(3, 0);
    for (int i = 0; i < nums.size(); ++i) {
        count[nums[i]]++;
    }
    int index = 0;
    for (int i = 0; i < nums.size(); ++i) {
        while (count[index] <= 0) index++;
        nums[i] = index;
        count[index]--;

    }
}