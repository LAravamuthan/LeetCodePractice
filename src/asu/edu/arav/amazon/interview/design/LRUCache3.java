package asu.edu.arav.amazon.interview.design;

import java.util.HashMap;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/lru-cache/
 */
public class LRUCache3 {
    class DLLNode {
        int val;
        int key;
        DLLNode next;
        DLLNode prev;

        DLLNode() {

        }

        DLLNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public void removeNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNode(DLLNode node) {
        prehead.next.prev = node;
        node.next = prehead.next;
        prehead.next = node;
        node.prev = prehead;
    }

    public void moveToHead(DLLNode node) {
        removeNode(node);
        addNode(node);
    }

    public DLLNode removeTail() {
        DLLNode tail = postTail.prev;
        removeNode(tail);
        return tail;
    }


    HashMap<Integer, DLLNode> cacheMap = new HashMap<Integer, DLLNode>();
    int capacity = Integer.MIN_VALUE;
    DLLNode prehead, postTail;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        prehead = new DLLNode();
        postTail = new DLLNode();
        prehead.next = postTail;
        postTail.prev = prehead;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            DLLNode node = cacheMap.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        DLLNode newNode = new DLLNode(key, value);
        addNode(newNode);
        if(cacheMap.containsKey(key)){
            removeNode(cacheMap.get(key));
        }
        cacheMap.put(key, newNode);
        if (cacheMap.size() > capacity) {
            DLLNode dNode = removeTail();
            cacheMap.remove(dNode.key);
        }
    }


}
