package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
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
     * DFS approach with hold on head and cur.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(H).
     */
    public Node treeToDoublyList(Node root) {
        inOrder(root);
        Node head = dummyHead.right;
        head.left = cur;
        cur.right = head;
        return head;
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        cur.right = node;
        node.left = cur;
        cur = node;
        inOrder(node.right);
    }

    private Node dummyHead = new Node(-1);
    private Node cur = dummyHead;


    /**
     * DFS approach with hold on head and cur.
     * Practice.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(H).
     */
    public Node treeToDoublyList2(Node root) {
        if (root == null) return null;
        this.dH = new Node(-1);
        this.curNode = dH;
        dfsInOrder(root);
        this.dH.right.left = this.curNode;
        this.curNode.right = this.dH.right;
        return this.dH.right;
    }

    private void dfsInOrder(Node node) {
        if (node == null) return;
        dfsInOrder(node.left);
        node.left = curNode;
        curNode.right = node;
        curNode = curNode.right;
        dfsInOrder(node.right);
    }

    private Node dH;
    private Node curNode;

}
