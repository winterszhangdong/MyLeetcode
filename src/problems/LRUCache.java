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

    // from small to big
    class ListNode {
        public int key;
        public int value;
        public int count;
        public ListNode next;
        public ListNode pre;

        ListNode(int k, int v, int c) {
            this.key = k;
            this.value = v;
            this.count = c;
            this.next = null;
            this.pre = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, ListNode>();
        this.head = null;
    }

    public int get(int key) {
        if (this.cache.containsKey(key)) {
            ListNode node = this.cache.get(key);
            ListNode nextNode = node.next;
            node.count++;
            if (nextNode != null && node.count > node.next.count) {
                nextNode.pre = node.pre;
                node.next = nextNode.next;
                node.pre = nextNode;
                nextNode.next = node;
                if (node == this.head)
                    this.head = nextNode;
            }
            System.out.println("get " + key + ": " + node.value);
            return node.value;
        } else {
            System.out.println("get " + key + ": -1");
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.cache.containsKey(key)) {
            this.cache.get(key).value = value;
        } else if (this.cache.size() < this.capacity) {
            ListNode node = new ListNode(key, value, 1);
            node.next = this.head;
            if (this.head != null)
                this.head.pre = node;
            this.head = node;
            this.cache.put(key, node);
        } else {
            this.cache.remove(this.head.key);
            ListNode node = this.head;
            while (node.next != null && node.next.value == 1)
                node = node.next;
//            if (node.next == null)
            this.head.value = value;
            this.head.count = 1;
            this.cache.put(key, this.head);
        }
        System.out.println("put key: " + key + " value: " + this.cache.get(key).value);
    }
}
