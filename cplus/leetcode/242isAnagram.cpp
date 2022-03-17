//
// Created by slwhy on 2022/3/17.
//
#include "string"

using namespace std;

bool isAnagram(string s, string t) {
    int *chars = new int[26]();
    int lengS = s.size();
    int lengT = t.size();
    if (lengS != lengT) return false;
    for (int i = 0; i < lengS; ++i) {
        chars[s[i] - 'a'] += 1;
        chars[t[i] - 'a'] -= 1;
    }
    for (int i = 0; i < lengT; ++i) {
        if (chars[t[i] - 'a'] != 0) return false;
    }
    return true;
}
