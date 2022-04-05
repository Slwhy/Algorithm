//
// Created by slwhy on 2022/4/5.
//
#include "vector"

using namespace std;

bool increasingTriplet2(vector<int> &nums) {
    if (nums.size() < 3)return false;
    int first = INT_MAX, second = INT_MAX;
    for (int i = 0; i < nums.size(); ++i) {
        if (nums[i] > second) return true;
        else if (nums[i] < first) first = nums[i];
        else if (nums[i] > first && nums[i] < second) second = nums[i];
    }
    return false;
//    int first = nums[0], second;
//    int start = -1;
//    for (int i = 1; i < nums.size() - 1; ++i) {
//        if (nums[i] > first) {
//            start = i + 1;
//            second = nums[i];
//            break;
//        } else first = nums[i];
//    }
//    if (start < 1) return false;
//    for (int i = start; i < nums.size(); ++i) {
//        if (nums[i] > second) return true;
//        else if (nums[i] < first) {
//            first = nums[i];
//        } else if (nums[i] < second && nums[i] > first) second = nums[i];
//    }
//    return false;
}


bool increasingTriplet(vector<int> &nums) {
    if (nums.size() < 3) return false;
    int min = nums[0];
    vector<int> maxBack = vector<int>(nums.size());
    maxBack[nums.size() - 2] = nums[nums.size() - 1];
    for (int i = nums.size() - 3; i >= 0; i--) {
        if (nums[i + 1] > maxBack[i + 1]) {
            maxBack[i] = nums[i + 1];
        } else maxBack[i] = maxBack[i + 1];
    }
    for (int i = 1; i < nums.size() - 1; ++i) {
        if (nums[i] > min && nums[i] < maxBack[i]) {
            return true;
        } else if (nums[i] < min) min = nums[i];
    }
    return false;
}
