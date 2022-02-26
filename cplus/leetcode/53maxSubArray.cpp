//
// Created by slwhy on 2022/2/26.
//
#include "vector"

using namespace std;

int maxSubArray(vector<int> &nums) {
    int maxSum = 0;
    int sumLast = -1;
    maxSum = nums[0];
    for (int i = 0; i < nums.size(); ++i) {
        if (sumLast < 0) sumLast = 0;
        sumLast = sumLast + nums[i];
        maxSum = maxSum > sumLast ? maxSum : sumLast;
    }
    return maxSum;
}

int maxSubArray2(vector<int> &nums) {
    int maxSum = 0;
    int array[nums.size()];
    array[0] = nums[0];
    maxSum = nums[0];
    for (int i = 1; i < nums.size(); ++i) {
        array[i] = array[i - 1] + nums[i] > nums[i] ? array[i - 1] + nums[i] : nums[i];
        maxSum = maxSum > array[i] ? maxSum : array[i];
    }
    return maxSum;
}