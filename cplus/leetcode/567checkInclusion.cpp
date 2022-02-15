//
// Created by slwhy on 2022/2/14.
//
#include "string"
#include "map"
#include "vector"

using namespace std;

bool checkInclusion(string s1, string s2) {
    int m = s1.size(), n = s2.size();
    if (n<m) return false;
    vector<int> cnt1(26),cnt2(26);
    for (int i = 0; i < m; ++i) {
        cnt1[s1[i]-'a']++;
        cnt2[s2[i]-'a']++;
    }
    if (cnt1==cnt2) return true;
    for (int i = m; i < n; ++i) {
        cnt2[s2[i]-'a']++;
        cnt2[s2[i-m]-'a']--;
        if (cnt2==cnt1) return true;
    }
    return false;
}

bool checkInclusion2(string s1, string s2) {
    /**
     * 枚举，超时
     */
    map<char, int> charCountS1;
    bool flag;
    for (int i = 0; i < s1.size(); ++i) {
        charCountS1[s1[i]]++;
    }
    for (int i = 0; i <= s2.size() - s1.size(); ++i) {
        int index = i;
        flag = false;
        map<char, int> charCountS2;
        while (index < s2.size() && index - i < s1.size() && charCountS1.count(s2[index]) > 0)
            charCountS2[s2[index++]]++;
        if (index - i == s1.size()) {
            flag = true;
            map<char, int>::iterator iter = charCountS1.begin();
            while (iter != charCountS1.end()) {
                if (iter->second != charCountS2.count(iter->first)) flag = false;
                iter++;
            }
        }
        if (flag) return true;
    }
    return false;
}

