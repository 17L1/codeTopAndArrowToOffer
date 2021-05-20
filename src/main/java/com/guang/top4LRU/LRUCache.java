package com.guang.top4LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache{
    class DoubleList{
        int key;
        int val;
        DoubleList next;
        DoubleList pre;
        public DoubleList(int key,int val) {
            this.key = key;
            this.val = val;
        }
        public DoubleList(int val) {
            this.val = val;
        }
        public DoubleList() {
        }
    }
    private Map<Integer,DoubleList> cache = new HashMap<Integer, DoubleList>();
    private int size;
    private int capacity;
    private DoubleList head;
    private DoubleList tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DoubleList();
        tail = new DoubleList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleList node = cache.get(key);
        if (node == null){
            return -1;
        }else {
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        DoubleList node = cache.get(key);
        if (node == null){
            DoubleList newNode = new DoubleList(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size >capacity){
                DoubleList lastNode = removeTail();
                cache.remove(lastNode.key);
                size--;
            }
        }else {
            node.val = value;
            moveToHead(node);
        }
    }

    private DoubleList removeTail() {
        DoubleList res = tail.pre;
        removeNode(res);
        return res;
    }

    private void removeNode(DoubleList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(DoubleList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
    }
    private void moveToHead(DoubleList node) {
        removeNode(node);
        addToHead(node);
    }
}

