//
// Created by slwhy on 2021/8/19.
// Desc:345. 反转字符串中的元音字母
//

#include "vector"
#include "string"
#include "set"
#include "iostream"

using namespace std;
//vector<char> vowelVec({'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'});
set<char> vowel = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

string reverseVowels(string s) {
    int left = 0, right = s.size() - 1;
    char tmp;
    while (left < right) {
        while (left < right && vowel.find(s[left]) == vowel.end()) left++;
        while (left < right && vowel.find(s[right]) == vowel.end()) right--;
        tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        left++;
        right--;
    }
    return s;
}

