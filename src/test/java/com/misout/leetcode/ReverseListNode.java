package com.misout.leetcode;

import com.misout.list.ListNode;
import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-16 17:05:23
 */
public class ReverseListNode {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = head;
        ListNode current = head.next;
        head.next = null;
        while(current != null) {
            ListNode temp = current.next;
            current.next = newHead;
            newHead = current;
            current = temp;
        }
        return newHead;
    }

    @Test
    public void test_reverseList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newList = reverseList(node1);
        System.out.println(newList);
    }
}
