package com.guang.top54排序链表;

import java.util.List;

public class Solution2 {
    public ListNode sortList(ListNode head) {
        return quickSort(head,null);
    }

    private ListNode quickSort(ListNode head, ListNode end) {
        if (head == end || head.next == end){
            return head;
        }
        ListNode lhead = head;
        ListNode utail = head;
        ListNode p = head.next;
        while (p != end){
            ListNode next = p.next;
            //头插
            if (p.val < head.val){
                p.next = lhead;
                lhead = p;
            }else {
                //尾插
                utail.next = p;
                utail = p;
            }
            p = next;

        }
        utail.next = end;
        ListNode node = quickSort(lhead,head);
        head.next = quickSort(head.next,end);
        return node;

    }
}
