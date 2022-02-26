//
// Created by slwhy on 2022/2/25.
//
#include "iostream"

using namespace std;

int fib(int n) {
    if (n < 2) return n;
    int first = 0, second = 1, curr = 0;
    while (n-- >= 2) {
        curr = first + second;
        first = second;
        second = curr;
    }
    return curr;
}
