//
// Created by slwhy on 2022/3/17.
//
#include "vector"
#include "string"

using namespace std;

int firstUniqChar(string s) {
    int *chars = new int[26]();
    //vector<int> chars(26,0);
    int leng = s.size();
    for (int i = 0; i < leng; ++i) {
        chars[s[i] - 'a'] += 1;
    }
    for (int i = 0; i < leng; ++i) {
        if (chars[s[i] - 'a'] == 1) return i;
    }
    return -1;
}
