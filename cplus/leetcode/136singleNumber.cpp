//
// Created by slwhy on 2022/2/22.
//
#include "vector"

using namespace std;

int singleNumber(vector<int> &nums) {
    int n = 0;
    for (int i = 0; i < nums.size(); ++i) {
        n = n ^ nums[i];
    }
    return n;
}