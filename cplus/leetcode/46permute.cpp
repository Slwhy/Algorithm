//
// Created by slwhy on 2022/2/19.
//
#include "iostream"
#include "vector"

using namespace std;

vector<vector<int>> resPermute;

void swapSelf(vector<int> &nums, int left, int right) {
    int tmp = nums[left];
    nums[left] = nums[right];
    nums[right] = tmp;
}

void permuteCore(vector<int> currNums, int index) {
    if (index == currNums.size() - 1) resPermute.emplace_back(currNums);
    else {
        permuteCore(currNums, index + 1);
        for (int i = index + 1; i < currNums.size(); ++i) {
            swapSelf(currNums, index, i);
            permuteCore(currNums, index + 1);
            swapSelf(currNums, i, index);
        }
    }
}

vector<vector<int>> permute(vector<int> &nums) {
    permuteCore(nums, 0);
    return resPermute;
}

//int main() {
//    vector<int> nums = {1, 2, 3};
//    permute(nums);
//}