//
// Created by slwhy on 2022/2/13.
//

//  Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* removeNthFromEnd(ListNode* head, int n) {
    ListNode newHead = ListNode(0);
    newHead.next = head;
    ListNode* left = &newHead;
    ListNode* right = head;
    while (right!= nullptr && n>0){
        right = right->next;
        n--;
    }
    while (right!= nullptr){
        right = right->next;
        left = left->next;
    }
    ListNode* tmp = left->next;
    left->next = left->next->next;
    delete tmp;
    return newHead.next;
}