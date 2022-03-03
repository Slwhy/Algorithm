//
// Created by slwhy on 2022/3/3.
//
#include "vector"
#include "string"

using namespace std;

bool cmpStr(const string& s1, const string& s2) {
    if (s1.size() == s2.size()) {
        return s1 + s2 < s2 + s1;
    } else return s1.size() > s2.size();
}

string findLongestWord(string s, vector<string> &dictionary) {
    // 排序+双指针
    sort(dictionary.begin(), dictionary.end(), cmpStr);
    for (int i = 0; i < dictionary.size(); ++i) {
        string curr = dictionary[i];
        int indexS = 0, indexC = 0;
        while (indexS < s.size() && indexC < curr.size()) {
            if (s[indexS] == curr[indexC]) indexC++;
            indexS++;
        }
        if (indexC == curr.size()) return curr;
    }
    return "";
}