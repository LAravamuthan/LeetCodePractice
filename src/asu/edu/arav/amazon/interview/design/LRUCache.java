package asu.edu.arav.amazon.interview.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {

    class DLLNode {
        int key, value;
        DLLNode next, prev;

        DLLNode() {

        }

        DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, DLLNode> cache = new HashMap<Integer, DLLNode>();
    DLLNode head;
    DLLNode tail;
    int capacity;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLLNode();
        tail = new DLLNode();
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode node) {
        DLLNode temp = head.next;
        temp.prev = node;
        head.next = node;
        node.next = temp;
        node.prev = head;
    }

    public void removeNode(DLLNode node) {
        DLLNode prev = node.prev;
        DLLNode next = node.next;
        next.prev = prev;
        prev.next = next;
    }

    public DLLNode removeFromTail() {
        DLLNode old = tail.prev;
        removeNode(tail.prev);
        return old;
    }

    public void moveNodeTOHead(DLLNode node) {
        removeNode(node);
        addNode(node);
    }


    public int get(int key) {
        if (cache.get(key) != null) {
            moveNodeTOHead(cache.get(key));
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLLNode node = cache.get(key);
        if (node == null) {
            if (cache.size() == capacity) {
                DLLNode tail = removeFromTail();
                cache.remove(tail.key);
            }
            DLLNode newNode = new DLLNode(key, value);
            addNode(newNode);
            cache.put(key, head.next);
        } else {
            node.value = value;
            moveNodeTOHead(node);
        }
    }
}
