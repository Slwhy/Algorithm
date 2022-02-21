//
// Created by slwhy on 2022/2/21.
//

#include "cstdint"

using namespace std;

int hammingWeight(uint32_t n) {
    int count = 0;
    while (n != 0) {
        n = n & (n - 1);
        count++;
    }
    return count;
}
