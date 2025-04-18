package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class LRUCache {

    public class DLListNode {
        int key;
        int val;
        DLListNode next;
        DLListNode prev;

        DLListNode() {
        }

        DLListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        DLListNode(int key, int val, DLListNode next, DLListNode prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }


    /**
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * Output
     */

    private int capacity;
    private Map<Integer, DLListNode> store;
    private DLListNode head;
    private DLListNode tail;

    /**
     * Init method to initialize the internal states.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1)
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
        this.head = new DLListNode(0, 0);
        this.tail = new DLListNode(0, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    /**
     * The get method this works in O(1).
     *
     * @time-complexity - O (1).
     * @space-complexity - O (capacity)
     */
    public int get(int key) {
        if (!store.containsKey(key)) return -1;
        DLListNode node = store.get(key);
        delete(node);
        add(node);
        return node.val;
    }

    /**
     * Typical put method, nice work buddy.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (capacity)
     */
    public void put(int key, int value) {
        DLListNode node = new DLListNode(key, value);
        if (store.containsKey(key)) delete(store.get(key));
        store.put(key, node);
        add(node);
        if (store.size() > capacity) {
            DLListNode nodeToRemove = head.next;
            delete(nodeToRemove);
            store.remove(nodeToRemove.key);
        }
    }


    public static void main (String[] args) {

        /**
         * ["LRUCache","put","put","put","put","get","get"]
         * [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
         */
        LRUCache lruCache = new LRUCache(2);
        //System.out.println("[2] " + lruCache.get(2));
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println("[1] " + lruCache.get(1));
        System.out.println("[2] " + lruCache.get(2));
    }


    private void add(DLListNode node) {
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }

    private void delete(DLListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
