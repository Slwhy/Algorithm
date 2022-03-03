//
// Created by slwhy on 2022/2/24.
//
#include "vector"

using namespace std;

vector<vector<int>> resultFourSum;

void twoSum(vector<int> &nums, int left, int right, int target, int m, int n) {
    while (left < right) {
        if (nums[left] + nums[right] == target) {
            vector<int> tmp = {m, n, nums[left], nums[right]};
            resultFourSum.emplace_back(tmp);
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) left++;
        } else if (nums[left] + nums[right] > target) right--;
        else left++;
    }
}

vector<vector<int>> fourSum(vector<int> &nums, int target) {
    if (nums.size()<4) return resultFourSum;
    std::sort(nums.begin(), nums.end());
    // 注意这里 i=0 是直接进入循环的，没有判断 i < num.size()-3
    for (int i = 0; i < nums.size() - 3; ++i) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        for (int j = i + 1; j < nums.size() - 2; ++j) {
            if (j>i+1 && nums[j] == nums[j - 1]) continue;
            twoSum(nums, j + 1, nums.size() - 1, target - nums[i] - nums[j], nums[i], nums[j]);
        }
    }
    return resultFourSum;
}
