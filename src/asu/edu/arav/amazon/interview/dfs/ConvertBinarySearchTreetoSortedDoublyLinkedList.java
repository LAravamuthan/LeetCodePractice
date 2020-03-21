package asu.edu.arav.amazon.interview.dfs;




/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
 */
public class ConvertBinarySearchTreetoSortedDoublyLinkedList {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

    /**
     *
     * @algo - DFS inorder
     * @time-complexity - O(n)
     * @space-complexity - O(log n)
     */

    Node head = null;
    Node tail = null;

    public Node treeToDoublyList(Node root) {
        inOrder(root);
        if(head != null){
            head.left = tail;
            tail.right = head;
        }
        return head;
    }

    public void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        if(tail != null){
            tail.right = node;
            node.left = tail;
        }else{
            head = node;
        }
        tail = node;
        inOrder(node.right);
    }





}
