//
// Created by slwhy on 2021/9/14.
// Desc:189. 旋转数组
//
#include "vector"
#include "queue"

using namespace std;

void rotate2(vector<int> &nums, int k) {
    vector<int> rightVec(k);
    int len = nums.size();
    for (int i = 0; i < k; ++i) {
        rightVec[k - i - 1] = nums[(len - i - 1 + len) % len];
    }
    for (int i = len - k - 1; i >= 0; --i) {
        nums[(i + k) % len] = nums[i];
    }
    for (int i = 0; i < k & i < len; ++i) {
        nums[i] = rightVec[i];
    }
}

void rotate(vector<int> &nums, int k) {
    /*
     * 暴力，用数组存储所有整个数组
     */
    int len = nums.size();
    vector<int> res(len);
    for (int i = 0; i < len; ++i) {
        res[(i + k) % len] = nums[i];
    }
    nums = res;
}
