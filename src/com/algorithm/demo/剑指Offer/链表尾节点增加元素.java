package com.algorithm.demo.剑指Offer;

import com.algorithm.demo.linkedlist.LinkNode;

public class 链表尾节点增加元素 {


    public void AddToTail(LinkNode head, int val){
        LinkNode newNode = new LinkNode(val);
        if(head == null){
            head = newNode;
        }else{
            LinkNode node = head;
            while(node.next != null){
                node = node.next;
            }
            node.next = newNode;
        }
    }

}
