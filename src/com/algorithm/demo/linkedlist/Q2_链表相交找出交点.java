package com.algorithm.demo.linkedlist;

public class Q2_链表相交找出交点 {
    /**
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public LinkNode getIntersectionNode(LinkNode headA, LinkNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        LinkNode a = headA;
        LinkNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
