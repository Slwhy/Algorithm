//
// Created by slwhy on 2022/3/18.
//
#include "iostream"

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

bool hasCycle(ListNode *head) {
    ListNode *quick = head;
    ListNode *slow = head;
    while (quick != NULL && slow != NULL) {
        slow = slow->next;
        quick = quick->next;
        if (quick != NULL) quick = quick->next;
        else break;
        if (slow == quick) return true;
    }
    return false;
}