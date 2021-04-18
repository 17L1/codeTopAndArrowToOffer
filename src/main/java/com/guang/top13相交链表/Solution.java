package com.guang.top13相交链表;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode slowA = headA;
        ListNode slowB = headB;
        while (slowA != slowB){
            slowA = slowA != null ? slowA.next : headB;
            slowB = slowB != null ? slowB.next : headA;
        }
        return slowA;
    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
