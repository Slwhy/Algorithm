//
// Created by slwhy on 2021/7/30.
//
#include "vector"
#include <istream>

using namespace std;

class Solution {
public:
    int searchBinarySearchRecru(vector<int> &nums, int target, int left, int right) {
        /*
         * 递归实现
         */
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) {
            return searchBinarySearchRecru(nums, target, left, mid - 1);
        } else {
            return searchBinarySearchRecru(nums, target, mid + 1, right);
        }

    }

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

    int search1(vector<int> &nums, int target) {
        /*
         * 循环实现
         */
        int left = 0, right = nums.size() - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
};