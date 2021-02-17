package com.algorithm.demo.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class 相反的顺序存储 {

    public static void main(String[] args) {

    }

    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> integers = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            System.out.println(" " + curr.val);
            curr = curr.next;
            integers.add(curr.val);
        }
        return integers;
    }

}
