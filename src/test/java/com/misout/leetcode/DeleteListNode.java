package com.misout.leetcode;

import com.misout.list.ListNode;
import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-16 16:10:12
 */
public class DeleteListNode {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    @Test
    public void test_deleteNode() {
        ListNode newNode = new ListNode(4);
        ListNode newNode2 = new ListNode(5);
        ListNode newNode3 = new ListNode(1);
        ListNode newNode4 = new ListNode(9);

        newNode.next = newNode2;
        newNode2.next = newNode3;
        newNode3.next = newNode4;

        deleteNode(newNode2);
        System.out.println(newNode);
    }

}
