//
// Created by slwhy on 2021/8/10.
// Desc: 413. 等差数列划分
//
#include "vector"

using namespace std;

int numberOfArithmeticSlices(vector<int> &nums) {
    /*
     * dp解法
     * if nums[i]-nums[i-1]==distance(等差数列的差值) dp[i] = dp[i-1] + (i-left-1)
     * else dp[i] = dp[i-1] ,left = i-1,distance=nums[i]-nums[i-1]
     */
    if (nums.size()<3) return 0;
    else{
        int res = 0, left = 0, distance = 0;
        distance = nums[1]-nums[0];
        for (int i = 2; i < nums.size(); ++i) {
            if (distance==nums[i]-nums[i-1]){
                res += (i-left-1);
            } else{
                distance = nums[i]-nums[i-1];
                left = i-1;
            }
        }
        return res;
    }
}
