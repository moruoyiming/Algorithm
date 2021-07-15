package com.algorithm.demo.interview;

import com.algorithm.demo.linkedlist.LinkNode;

public class 判断链表是否有环 {

    public static void main(String[] args) {

    }

    public static Boolean hasCycle(LinkNode head) {
        if(head==null || head.next==null){
            return false;
        }
        LinkNode fast = head.next;
        LinkNode slow = head;
        while(fast!=slow){
            if(fast ==null || fast.next ==null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
