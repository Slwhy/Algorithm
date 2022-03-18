//
// Created by slwhy on 2022/3/18.
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

ListNode *removeElements(ListNode *head, int val) {
    ListNode root = ListNode(0);
    root.next = head;
    ListNode *pre = &root;
    ListNode *curr = head;
    while (curr != nullptr) {
        if (curr->val == val) {
            pre->next = curr->next;
            curr = curr->next;
        } else {
            pre = curr;
            curr = curr->next;
        }
    }
    return root.next;
}