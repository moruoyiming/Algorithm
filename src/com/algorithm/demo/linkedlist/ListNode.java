package com.algorithm.demo.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {}

}
