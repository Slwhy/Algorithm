//
// Created by slwhy on 2022/2/20.
//
#include "iostream"

using namespace std;

int climbStairsCore(int n) {
    if (n < 3) return n;
    return climbStairsCore(n - 1) + climbStairsCore(n - 2);
}

int climbStairs(int n) {
    if (n < 3) return n;
    int pre = 1, curr = 2, next = 3;
    for (int i = 3; i <= n; i++) {
        next = pre + curr;
        pre = curr;
        curr = next;
    }
    return curr;
}
