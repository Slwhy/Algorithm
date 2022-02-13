//
// Created by slwhy on 2022/2/12.
//
#include "iostream"
#include "string"
using namespace std;

string reverseWords(string s) {
    int left=0,right=0,index=0;
    char tmp;
    while (index<s.size()){
        while (index<s.size() && s[index]!=' ') index++;
        right = index-1;
        //while (s[index]==' ') index++;
        index++;
        while (left<right){
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
        left = index;
    }
    return s;
}