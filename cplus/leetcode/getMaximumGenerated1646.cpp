//
// Created by slwhy on 2021/8/23.
// Desc:1646. 获取生成数组中的最大值
//
#include "vector"

using namespace std;

int getMaximumGenerated(int n) {
    if (n < 2) return n;
    else {
        int res;
        vector<int> nums(n + 1);
        nums[0]=0,nums[1]=1;
        for (int i = 2; i <= n; ++i) {
            if (i % 2 == 0) {
                nums[i] = nums[i / 2];
            } else{
                nums[i] = nums[i/2] + nums[i/2+1];
            }
            res = res > nums[i] ? res : nums[i];
        }
        return res;
    }

}