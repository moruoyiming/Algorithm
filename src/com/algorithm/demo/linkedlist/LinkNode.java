package com.algorithm.demo.linkedlist;

public class LinkNode {
    public int val;
    public LinkNode next;

    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }

    public LinkNode(int x) {
        val = x;
        next = null;
    }

    public LinkNode() {}

}
