//
// Created by slwhy on 2022/2/27.
//
#include "string"
#include "map"
#include "set"
#include "stack"

using namespace std;

bool isValid(string s) {
    set<char> leftSymbol({'(', '[', '{'});
    //set<char> rightSymbol({')', ']', '}'});
    map<char, char> symbolMap{{')', '('},
                              {']', '['},
                              {'}', '{'}};
    stack<char> stackCh;
    for (int i = 0; i < s.size(); ++i) {
        if (leftSymbol.find(s[i]) != leftSymbol.end()) {
            stackCh.push(s[i]);
        } else if (!stackCh.empty() && symbolMap.find(s[i]) != symbolMap.end()) {
            if (stackCh.top() != symbolMap.find(s[i])->second) return false;
            stackCh.pop();
        } else return false;
    }
    return stackCh.empty();
}