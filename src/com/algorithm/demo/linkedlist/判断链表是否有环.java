package com.algorithm.demo.linkedlist;

public class 判断链表是否有环 {

    public static void main(String[] args) {

    }

    public static Boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast, slow;
        fast = head.next;
        slow = head;
        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}
