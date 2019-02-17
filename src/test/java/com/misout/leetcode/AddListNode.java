package com.misout.leetcode;

import com.misout.list.ListNode;
import org.junit.Test;

/**
 * @author Misout
 * @date 2019-02-17 14:07:09
 */
public class AddListNode {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode newList = null;
        ListNode newP = null;
        while(p1 != null || p2 != null) {
            ListNode newNode = new ListNode(0);
            int p1Val = (p1 == null) ? 0 : p1.val;
            int p2Val = (p2 == null) ? 0 : p2.val;
            newNode.val = p1Val + p2Val;
            if(newP == null) {
                newP = newNode;
                newList = newNode;
            } else {
                newP.next = newNode;
                newP = newNode;
            }
            p1 = (p1 != null) ? p1.next : null;
            p2 = (p2 != null) ? p2.next : null;
        }

        newP = newList;
        while(newP != null) {
            if(newP.val < 10) {
                newP = newP.next;
                continue;
            }

            int highBit = newP.val / 10;
            int lowBit = newP.val % 10;
            newP.val = lowBit;
            if(newP.next == null) {
                ListNode temp = new ListNode(highBit);
                newP.next = temp;
            } else {
                newP.next.val += highBit;
            }
            newP = newP.next;
        }
        return newList;
    }

    @Test
    public void test_addTwoNumbers() {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode list1 = node1;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(0);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        ListNode list2 = node4;

        ListNode result  = addTwoNumbers(list1, list2);
        System.out.println(result);
    }
}
