package com.guang.top41重排链表;

import java.util.List;

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null){
            return;
        }
        ListNode middleNode = findMiddle(head);
        ListNode secondNodeFirst = middleNode.next;
        middleNode.next = null;
        secondNodeFirst = reverseListNode(secondNodeFirst);
        mergeTwoListNode(head,secondNodeFirst);
    }

    private void mergeTwoListNode(ListNode head, ListNode secondNodeFirst) {
        ListNode tmp1;
        ListNode tmp2;
        while (head != null && secondNodeFirst != null){
            tmp1 = head.next;
            tmp2 = secondNodeFirst.next;
            head.next = secondNodeFirst;
            head = tmp1;
            secondNodeFirst.next = head;
            secondNodeFirst = tmp2;
        }
    }

    private ListNode reverseListNode(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
class ListNode{
    int val;
    ListNode next;
}
