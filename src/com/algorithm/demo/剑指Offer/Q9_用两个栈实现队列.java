package com.algorithm.demo.剑指Offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的连哥哥函数appendTail和deleteHead,
 * 分别完成在队列尾部插入节点和在队列头部删除节点的功能
 */
public class Q9_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() == 0) {
            while (!stack1.isEmpty()) {
                int temp = stack1.peek();
                stack2.push(temp);
                stack1.pop();
            }
        }
        int res = stack2.peek();
        stack2.pop();
        return res;
    }

}
