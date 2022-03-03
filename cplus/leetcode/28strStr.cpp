//
// Created by slwhy on 2022/3/3.
//
#include "string"

using namespace std;

//KMP
//https://www.zhihu.com/question/21923021/answer/281346746

int strStr(string haystack, string needle) {
    int h = 0, n = 0;
    int start = 0;
    while (h < haystack.size()) {
        if (n >= needle.size()) break;
        if (haystack[h] == needle[n]) {
            n++;
            h++;
        } else {
            n = 0;
            h = start + 1;
            start++;
        }
    }
    if (n == needle.size()) return h - needle.size();
    else return -1;
}
