package com.guang.top54排序链表;

import java.util.List;

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                pre.next = left;
                left = left.next;
                pre = pre.next;
            }else {
                pre.next = right;
                right = right.next;
                pre = pre.next;
            }
        }
        pre.next = left != null ? left:right;
        return dummy.next;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
