//
// Created by slwhy on 2022/2/11.
//
#include "iostream"
#include "vector"

using namespace std;

vector<int> twoSum2(vector<int> &numbers, int target) {
    int left = 0, right = numbers.size()-1;
    while (left < right) {
        int sum = numbers[left] + numbers[right];
        if (sum == target) break;
        else if (sum < target) left++;
        else right--;
    }
    //vector<int> array{left+1,right+1};
    return {left+1,right+1};
}