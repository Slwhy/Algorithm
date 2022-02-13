//
// Created by slwhy on 2022/2/13.
//
#include "iostream"

using namespace std;

//  Definition for singly-linked list.
  struct ListNode {
      int val;
      ListNode *next;
      ListNode() : val(0), next(nullptr) {}
      ListNode(int x) : val(x), next(nullptr) {}
      ListNode(int x, ListNode *next) : val(x), next(next) {}
  };

ListNode* middleNode(ListNode* head) {
    /*
     * 快慢指针
     */
    ListNode* quickP = head;
    ListNode* slowP = head;
    //[1,2,3,4,5,6]
    while (quickP!= nullptr && quickP->next!= nullptr){
        quickP = quickP->next;
        if (quickP!= nullptr) quickP = quickP->next;
        slowP = slowP->next;
    }
    return slowP;
}


ListNode* middleNode2(ListNode* head) {
    ListNode* p = head;
    int length = 0,index=0;
    while (p!= nullptr){
        length++;
        p = p->next;
    }
    index = length/2;
    p = head;
    while (index-->0){
        p = p->next;
    }
    return p;
}