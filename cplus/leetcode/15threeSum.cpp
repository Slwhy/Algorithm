//
// Created by slwhy on 2022/2/24.
//

#include "vector"

using namespace std;

vector<vector<int>> resultThreeSum;

void twoSum(vector<int> &nums, int left, int right, int target) {
    while (left < right) {
        if (nums[left] + nums[right] == target) {
            vector<int> tmp = {-target, nums[left], nums[right]};
            resultThreeSum.emplace_back(tmp);
            left++;
            right--;
            while (left < right && nums[left] == nums[left - 1]) left++;
        } else if (nums[left] + nums[right] > target) right--;
        else left++;
    }
}

vector<vector<int>> threeSum(vector<int> &nums) {
    std::sort(nums.begin(), nums.end());
    for (int i = 0; i < nums.size(); ++i) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        twoSum(nums, i+1, nums.size() - 1, -nums[i]);
    }
    return resultThreeSum;
}
