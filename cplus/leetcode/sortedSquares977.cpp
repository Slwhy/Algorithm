//
// Created by slwhy on 2021/8/9.
// Desc:977. 有序数组的平方
//
#include "vector"

using namespace std;

vector<int> sortedSquares1(vector<int> &nums) {
    /*
     * 双指针法,平方之后，最小值不知道在哪，但最大值一定在左右两端
     */
    vector<int> res(nums.size());
    int index = nums.size() - 1, left = 0, right = nums.size() - 1;
    while (left <= right) {
        if (nums[left] * nums[left] > nums[right] * nums[right]) {
            res[index--] = nums[left] * nums[left];
            left++;
        } else {
            res[index--] = nums[right] * nums[right];
            right--;
        }
    }
    return res;
}

vector<int> sortedSquares(vector<int> &nums) {
    /*
     * 先平方,然后排序
     */
    vector<int> res(nums.size());
    for (int i = 0; i < nums.size(); ++i) {
        res[i] = nums[i] * nums[i];
    }
    sort(res.begin(), res.end());
    return res;
}