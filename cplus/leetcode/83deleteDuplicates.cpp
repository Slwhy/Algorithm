//
// Created by slwhy on 2022/3/19.
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

ListNode *deleteDuplicates(ListNode *head) {
    if (head == nullptr or head->next == nullptr) return head;
    ListNode *pre = head;
    ListNode *curr = head->next;
    while (curr != nullptr) {
        if (curr->val == pre->val) {
            pre->next = curr->next;
            curr = curr->next;
        } else {
            pre = curr;
            curr = curr->next;
        }
    }
    return head;
}
