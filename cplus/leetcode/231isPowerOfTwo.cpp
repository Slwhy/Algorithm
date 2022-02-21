//
// Created by slwhy on 2022/2/21.
//

#include "iostream"

using namespace std;

bool isPowerOfTwo(int n) {
    if(n<=0) return false;
    int num = n & (n - 1);
    if (num == 0) return true;
    else return false;
}



