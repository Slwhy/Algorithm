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

ListNode *reverse(ListNode *node, int k) {
    if (k <= 1 or node->next == nullptr) return node;
    else {
        ListNode *head = reverse(node->next, k - 1);
        node->next->next = node;
        node->next = nullptr;
        return head;
    }
}

ListNode *reverseKGroup(ListNode *head, int k) {
    ListNode *root = head;
    ListNode *start = head;
    ListNode *last = nullptr;
    ListNode *curr = head;
    int count = 0;
    while (curr != nullptr) {
        count++;
        ListNode *next = curr->next;
        if (count % k == 0) {
            ListNode *node = reverse(start, k);
            if (last == nullptr) root = node;
            else last->next = node;

            start->next = next;
            last = start;
            start = next;
        }
        curr = next;
    }
    return root;
}