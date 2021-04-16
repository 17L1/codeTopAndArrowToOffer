package com.guang.top6重排链表;

public class Solution {
    public void reorderList(ListNode head){
        if (head == null){
            return;
        }
        ListNode mid = findMidNode(head);
        ListNode head2 = reverseNode(mid.next);
        mid.next = null;
        mergeTwoListNode(head,head2);
    }

    private void mergeTwoListNode(ListNode head, ListNode head2){
        ListNode tmp1;
        ListNode tmp2;
        while (head != null && head2 != null){
            tmp1 = head.next;
            tmp2 = head2.next;
            head.next = head2;
            head = tmp1;
            head2.next = head;
            head2 = tmp2;
        }
    }

    private ListNode reverseNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode findMidNode(ListNode head) {
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

    public ListNode(int val) {
        this.val = val;
    }
}