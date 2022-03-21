//
// Created by slwhy on 2022/3/20.
//
#include "iostream"
#include "stack"

using namespace std;

class MyQueue {
public:
    stack<int> stack_f;
    stack<int> stack_s;

    MyQueue() {
        stack_f = stack<int>();
        stack_s = stack<int>();
    }

    void push(int x) {
        stack_f.push(x);
    }

    int pop() {
        int tmp = peek();
        stack_s.pop();
        return tmp;
    }

    int peek() {
        if (stack_s.empty()) {
            while (!stack_f.empty()) {
                stack_s.push(stack_f.top());
                stack_f.pop();
            }
        }
        return stack_s.top();
    }

    bool empty() {
        return stack_f.empty() && stack_s.empty();
    }
};

