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

ListNode *mergeTwoListsCore(ListNode *list1, ListNode *list2) {
    // 递归解法
    if (list1 == nullptr) return list2;
    else if (list2 == nullptr) return list1;
    else {
        if (list1->val <= list2->val) {
            list1->next = mergeTwoListsCore(list1->next, list2);
            return list1;
        } else {
            list2->next = mergeTwoListsCore(list1, list2->next);
            return list2;
        }
    }
}

ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
    ListNode head(0);
    ListNode *p = &head;
    while (list1 != nullptr && list2 != nullptr) {
        if (list1->val <= list2->val) {
            p->next = list1;
            p = p->next;
            list1 = list1->next;
        } else {
            p->next = list2;
            p = p->next;
            list2 = list2->next;
        }
    }
    if (list1 == nullptr) p->next = list2;
    else p->next = list1;
    return head.next;
}