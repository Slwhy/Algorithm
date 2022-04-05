//
// Created by slwhy on 2022/4/5.
//
#include "vector"

using namespace std;

vector<int> productExceptSelf2(vector<int> &nums) {
    // 基于方法1的空间优化，将前缀积存储在answer 数组中
    vector<int> answer = vector<int>(nums.size());
    int right = 1;
    answer[0] = 1;
    for (int i = 1; i < nums.size(); ++i) {
        answer[i] = answer[i - 1] * nums[i - 1];
    }
    for (int i = nums.size() - 1; i >= 0; i--) {
        answer[i] = answer[i] * right;
        right = right * nums[i];
    }
    return answer;
}

vector<int> productExceptSelf(vector<int> &nums) {
    vector<int> prefix = vector<int>(nums.size());
    vector<int> suffix = vector<int>(nums.size());
    vector<int> answer = vector<int>(nums.size());
    prefix[0] = 1;
    suffix[nums.size() - 1] = 1;
    for (int i = 1; i < nums.size(); ++i) {
        prefix[i] = prefix[i - 1] * nums[i - 1];
        suffix[nums.size() - 1 - i] = suffix[nums.size() - i] * nums[nums.size() - i];
    }
    for (int i = 1; i < nums.size() - 1; ++i) {
        answer[i] = prefix[i] * suffix[i];
    }
    answer[0] = suffix[0];
    answer[nums.size() - 1] = prefix[nums.size() - 1];
    return answer;
}