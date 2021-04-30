package com.guang.top36合并K个升序链表;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len < 1){
            return null;
        }
        ListNode res = sortListNode(lists,0,len-1);
        return res;
    }

    private ListNode sortListNode(ListNode[] lists, int left, int right) {
        if (left == right){
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode list1 = sortListNode(lists,left,mid);
        ListNode list2 = sortListNode(lists,mid + 1,right);
        return mergeTwoListNode(list1,list2);
    }

    private ListNode mergeTwoListNode(ListNode list1, ListNode list2) {
        ListNode tmp = new ListNode(0);
        ListNode dummy = tmp;
        while (list1 != null && list2 != null){
            if (list1 != null && list2 != null && list1.val <= list2.val){
                tmp.next = list1;
                list1 = list1.next;
                tmp = tmp.next;
            }
            if (list1 != null && list2 != null &&list1.val > list2.val){
                tmp.next = list2;
                list2 = list2.next;
                tmp = tmp.next;
            }
        }
        while (list1 != null){
            tmp.next = list1;
            list1 = list1.next;
            tmp = tmp.next;
        }
        while (list2 != null){
            tmp.next = list2;
            list2 = list2.next;
            tmp = tmp.next;


        }
        return dummy.next;


    }
}
class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode() {
    }
}
