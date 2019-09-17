package asu.edu.aravl.utility;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }
    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
