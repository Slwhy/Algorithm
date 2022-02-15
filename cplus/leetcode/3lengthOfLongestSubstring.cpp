//
// Created by slwhy on 2022/2/14.
//
#include "string"
#include "set"
#include "iostream"

using namespace std;

int lengthOfLongestSubstring(string s) {
    set<char> wind;
    int left = 0, right = 0;
    int max = 0;
    while (right < s.size()) {
        while (wind.find(s[right])!=wind.end()) wind.erase(s[left++]);
        wind.insert(s[right]);
        right++;
        max = max > (right - left) ? max : (right - left);
    }
    return max;
}

