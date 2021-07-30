//
// Created by slwhy on 2021/7/30.
//
#include "vector"
#include <istream>

using namespace std;

class Solution {
public:
    int search(vector<int> &nums, int target) {
        int left = 0, right = nums.size() - 1;
        int mid = (left + right) / 2;
        while (mid >= left && mid <= right) {
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
            mid = (left + right) / 2;
        }
        return -1;
    }
};