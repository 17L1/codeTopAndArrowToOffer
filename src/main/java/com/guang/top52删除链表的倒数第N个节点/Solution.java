package com.guang.top52删除链表的倒数第N个节点;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        //首先从头开始扫描，看看头结点的前N个节点离尾结点还有多远
        for (int i = 0; i <=n ; i++) {
            first = first.next;
        }
        //使用对称的思想看，如果first刚好为null的话，second刚好就是倒数第n个节点的前一个节点。
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
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