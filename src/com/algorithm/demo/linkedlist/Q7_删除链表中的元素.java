package com.algorithm.demo.linkedlist;

/**
 * 452. 删除链表中的元素
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 样例
 * Example 1:
 * <p>
 * Input: head = 1->2->3->3->4->5->3->null, val = 3
 * Output: 1->2->4->5->null
 * Example 2:
 * <p>
 * Input: head = 1->1->null, val = 1
 * Output: null
 *
 *
 * 方法：哨兵节点
 * 如果删除的节点是中间的节点，则问题似乎非常简单：
 *
 * 选择要删除节点的前一个结点 prev。
 * 将 prev 的 next 设置为要删除结点的 next。
 *
 *
 * 当要删除的一个或多个节点位于链表的头部时，事情会变得复杂。
 *
 *
 *
 * 可以通过哨兵节点去解决它，哨兵节点广泛应用于树和链表中，如伪头、伪尾、标记等，它们是纯功能的，通常不保存任何数据，其主要目的是使链表标准化，如使链表永不为空、永不无头、简化插入和删除。
 *
 *
 *
 * 在这里哨兵节点将被用于伪头。
 *
 * 算法：
 *
 * 初始化哨兵节点为 ListNode(0) 且设置 sentinel.next = head。
 * 初始化两个指针 curr 和 prev 指向当前节点和前继节点。
 * 当 curr != nullptr：
 * 比较当前节点和要删除的节点：
 * 若当前节点就是要删除的节点：则 prev.next = curr.next。
 * 否则设 prve = curr。
 * 遍历下一个元素：curr = curr.next。
 * 返回 sentinel.next。
 *
 */
public class Q7_删除链表中的元素 {

    public static void main(String[] args) {
        ListNode temp3 = new ListNode(5);
        ListNode temp2 = new ListNode(1, temp3);
        ListNode temp1 = new ListNode(3, temp2);
        ListNode temp = removeElements(temp1, 1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    /**
     * @param head: a ListNode
     * @param val:  An integer
     * @return: a ListNode
     */
    public static ListNode removeElements(ListNode head, int val) {
        // write your code here
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode pre = sentinel;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return sentinel.next;
    }

}
