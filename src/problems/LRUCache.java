package problems;


import java.util.HashMap;

/**
 * problem 146: LRU Cache
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LRUCache cache = new LRUCache( 2 // capacity);
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class LRUCache {
    private int capacity;
    private HashMap<Integer, ListNode> cache;
    private ListNode head;
    private ListNode tail;

    class ListNode {
        public int key;
        public int value;
        public ListNode next;
        public ListNode pre;

        ListNode (int k, int v) {
            this.key = k;
            this.value = v;
            this.next = null;
            this.pre = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, ListNode>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            ListNode node = this.cache.get(key);
            this.moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.capacity <= 0)
            return;

        if (this.cache.isEmpty()) {
            ListNode node = new ListNode(key, value);
            this.head = node;
            this.tail = node;
            this.cache.put(key, node);
            return;
        }

        if (this.cache.containsKey(key)) {
            ListNode node = this.cache.get(key);
            node.value = value;
            this.moveToHead(node);
        } else if (this.cache.size() < this.capacity) {
            ListNode node = new ListNode(key, value);
            node.next = this.head;
            this.head.pre = node;
            this.head = node;
            this.cache.put(key, node);
        } else {
            this.cache.remove(this.tail.key);
            ListNode node = this.tail;
            node.value = value;
            node.key = key;
            moveToHead(node);
            this.cache.put(key, node);
        }
    }

    private void moveToHead(ListNode node) {
        if (node == this.head)
            return;

        node.pre.next = node.next;
        if (node != this.tail)
            node.next.pre = node.pre;
        else
            this.tail = node.pre;

        node.next = this.head;
        this.head.pre = node;
        this.head = node;
    }
}
