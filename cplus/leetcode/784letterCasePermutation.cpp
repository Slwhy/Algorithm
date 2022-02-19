//
// Created by slwhy on 2022/2/19.
//

#include "string"
#include "vector"
#include "iostream"

using namespace std;

class letterCasePermutation784 {
public:
    vector<string> res;

    void letterCasePermutationCore(string s, int index) {
        if (index >= s.size()) res.emplace_back(s);
        else if (('a' <= s[index] && s[index] <= 'z') || ('A' <= s[index] && s[index] < 'Z')) {
            s[index] = tolower(s[index]);
            letterCasePermutationCore(s, index + 1);
            s[index] = toupper(s[index]);
            letterCasePermutationCore(s, index + 1);
        } else {
            letterCasePermutationCore(s, index + 1);
        }
    }

    vector<string> letterCasePermutation(string s) {
        letterCasePermutationCore(s, 0);
        return res;
    }

};
