//
// Created by slwhy on 2022/2/22.
//
#include "cstdint"

using namespace std;

uint32_t reverseBits(uint32_t n) {
    uint32_t res = 0;
    uint32_t count = 0;
    while (count < 32) {
        count++;
        res = res << 1;
        res += n & 1;
        n = n >> 1;
    }
    return res;
}