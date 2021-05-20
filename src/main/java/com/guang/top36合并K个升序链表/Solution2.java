package com.guang.top36合并K个升序链表;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: 17L1
 * @date: 2021年05月14日 7:37 下午
 * @method：
 */
public class Solution2 {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len < 1){
            return null;
        }
        PriorityQueue<ListNode> minHeap =
                new PriorityQueue<>(len, Comparator.comparingInt(o -> o.val));
        for(ListNode head : lists){
            if (head != null){
                minHeap.offer(head);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        while (!minHeap.isEmpty()){
            //注意：这里我们的选择是从优先队列里面拿出最小的元素再添加
            //事实上，如果优先队列有提供replace操作，应该优先选择replace
            ListNode top = minHeap.poll();
            curNode.next = top;
            curNode = curNode.next;
            if (top.next != null){
                minHeap.offer(top.next);
            }
        }
        return dummyNode.next;
    }

}
