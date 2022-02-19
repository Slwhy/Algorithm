//
// Created by slwhy on 2022/2/18.
//
#include "iostream"

using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
ListNode* reverseListCore(ListNode* head) {
    // 递归实现
    if (head== nullptr || head->next== nullptr) return head;
    ListNode* node = reverseListCore(head->next);
    ListNode* left = head;
    ListNode* right = head->next;
    right->next = left;
    left->next = nullptr;
    return node;
}

ListNode* reverseList(ListNode* head) {
    ListNode* curr = head;
    ListNode* pre = nullptr;
    while (curr!= nullptr){
        ListNode* nextNode = curr->next;
        curr->next = pre;
        pre = curr;
        curr = nextNode;
    }
    return pre;
}