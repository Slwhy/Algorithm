//
// Created by slwhy on 2022/3/17.
//
#include "string"

using namespace std;

bool canConstruct(string ransomNote, string magazine) {
    int *chars = new int[26]();
    int lengM = magazine.size();
    int lengR = ransomNote.size();
    for (int i = 0; i < lengM; ++i) {
        chars[magazine[i] - 'a'] += 1;
    }
    for (int i = 0; i < lengR; ++i) {
        chars[ransomNote[i] - 'a'] -= 1;
        if (chars[ransomNote[i] - 'a'] < 0) return false;
    }
    return true;

}