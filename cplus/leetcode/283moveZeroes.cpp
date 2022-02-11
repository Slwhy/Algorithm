//
// Created by slwhy on 2021/9/15.
//Desc:283. 移动零
#include "vector"
#include "iostream"

using namespace std;

void movZeros1(vector<int> &nums) {
    int left = 0, right = 0;
    while (right < nums.size()) {
        if (nums[right]) {
            swap(nums[left], nums[right]);
            left++;
        }
        right++;
    }
}


void moveZeroes(vector<int> &nums) {
    int left = 0, right = 0;
    while (right < nums.size() & nums[right] != 0)right++;
    left = right;
    while (right < nums.size()) {
        while (right < nums.size() & nums[right] == 0)right++;
        if (right < nums.size()) {
            nums[left++] = nums[right];
            nums[right++] = 0;
        }
    }
}

//int main() {
//    vector<int> nums(1, 0);
//    moveZeroes(nums);
//    cout << nums[0] << endl;
//    return 0;
//}

