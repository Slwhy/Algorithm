//
// Created by slwhy on 2022/2/12.
//
#include "iostream"
#include "vector"
using namespace std;


void reverseString(vector<char>& s) {
    int left=0,right=s.size()-1;
    char tmp;
    while (left<right){
        tmp = s[left];
        s[left]= s[right];
        s[right] =tmp;
        left++;
        right--;
    }
}