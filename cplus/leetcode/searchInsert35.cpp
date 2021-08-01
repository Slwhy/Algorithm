//
// Created by slwhy on 2021/7/31.
// Desc:35. 搜索插入位置
//
#include "vector"
#include "iostream"

using namespace std;

int searchInsertCore(vector<int> &nums, int target, int left, int right) {
    /*
     * 递归版二分搜索
     */
    if (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) return searchInsertCore(nums, target, mid + 1, right);
        else return searchInsertCore(nums, target, left, mid - 1);
    } else {
        if (nums[left] >= target) return left;
        else return left + 1;
    }
}

int searchInsert1(vector<int> &nums, int target) {
    return searchInsertCore(nums, target, 0, nums.size() - 1);
}

int searchInsert2(vector<int> &nums, int target) {
    /*
     * 循环版二分搜索
     */
    int left = 0, right = nums.size() - 1;
    int mid;
    while (left < right) {
        mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) right = mid - 1;
        else left = mid + 1;
    }
    if (nums[left] >= target) return left;
    else return left + 1;
}

int searchInsert(vector<int> &nums, int target) {
    /*
     * 暴力
     */
    for (int i = 0; i < nums.size(); ++i) {
        if (nums[i] >= target) return i;
    }
    return nums.size();
}


//int main() {
//    vector<int> nums = {1, 3, 5, 6};
//    int res = searchInsert(nums, 7);
//    cout << res << endl;
//    return 0;
//}